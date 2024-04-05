package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll(int page, int size) {
        String SQL_QUERY = "with users as (\n" +
                "    select * from \"user\" limit ? offset ?\n" +
                "),\n" +
                "room_owner as (\n" +
                "    select u.id, chat_room.id as chat_room_owner_id, chat_room.name, chat_room.owner from users u join chat_room on chat_room.owner = u.login\n" +
                "    ),\n" +
                "room_soc as (\n" +
                "    select u.id as id, u.login as login, u.password as password, chat_room_id from users u join user_chat_rooms ucr on ucr.user_id = u.id\n" +
                ")\n" +
                "select rs.id, rs.login, rs.password, rs.chat_room_id, cr.name, ro.chat_room_owner_id, cr2.name as room_owner_name\n" +
                "from room_soc rs\n" +
                "         full join room_owner ro on ro.id = rs.id\n" +
                "         left join chat_room cr on cr.id = rs.chat_room_id\n" +
                "         left join chat_room cr2 on cr2.id = chat_room_owner_id";


        Map<Long, User> userMap = new HashMap<>();
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_QUERY)) {
            statement.setInt(1, size);
            statement.setInt(2, size * page);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                userMap.computeIfAbsent(id, i -> new User(i, login, password, new ArrayList<>(), new ArrayList<>()));
                Long chat_room_id = resultSet.getLong("chat_room_id");
                String chat_room_name = resultSet.getString("name");
                userMap.get(id).getChatingRooms().add(new ChatRoom(chat_room_id, chat_room_name, null));
                Long chat_room_owner_id = resultSet.getLong("chat_room_owner_id");
                String room_owner_name = resultSet.getString("room_owner_name");
                if (room_owner_name != null) {
                    userMap.get(id).getCreatedRooms().add(new ChatRoom(chat_room_owner_id, room_owner_name, null));
                }
            }
        } catch (SQLException e) {
            System.err.println("Fetching all users failed :\n" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        List<User> users = new ArrayList<>(userMap.values());
        for (User u : users) {
            u.setChatingRooms(distinctList(u.getChatingRooms()));
            u.setCreatedRooms(distinctList(u.getCreatedRooms()));
        }
        return users;
    }

    private List<ChatRoom> distinctList(List<ChatRoom> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}
