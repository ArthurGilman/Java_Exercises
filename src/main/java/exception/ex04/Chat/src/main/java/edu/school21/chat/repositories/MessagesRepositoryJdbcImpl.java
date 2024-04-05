package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
        String SQL_QUERY = "select m.id       as id,\n" +
                "       text,\n" +
                "       date_time,\n" +
                "       u.id       as user_id,\n" +
                "       u.login    as login,\n" +
                "       u.password as password,\n" +
                "       cr.id      as room_id,\n" +
                "       cr.name    as room_name\n" +
                "from messages m\n" +
                "         join \"user\" u on u.login = m.author\n" +
                "         join chat_room cr on cr.name = m.room\n" +
                "where m.id = " + id;
        Optional<Message> res = Optional.empty();
        Message m = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery()){
            if (!rs.next()) {
                System.out.println("No element with this id");
            } else {
                m = new Message();
                do {
                    m.setId(rs.getLong("id"));
                    m.setText(rs.getString("text"));
                    m.setDateTime(rs.getTimestamp("date_time"));
                    User user = new User();
                    user.setId(rs.getLong("user_id"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    m.setAuthor(user);
                    ChatRoom cr = new ChatRoom();
                    cr.setId(rs.getLong("room_id"));
                    cr.setName(rs.getString("room_name"));
                    m.setRoom(cr);
                }
                while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Problem with sql query : \n" + e.getMessage());
        }
       res = Optional.ofNullable(m);
        return res;
    }

    @SneakyThrows
    @Override
    public void save(Message message) {
        if (message.getAuthor() == null || message.getAuthor().getId() == null) throw new NotSavedSubEntityException("Author ID is null");
        if (message.getRoom() == null || message.getRoom().getId() == null) throw new NotSavedSubEntityException("Chat_room ID is null");
        String SQL_QUERY = "INSERT INTO messages (author, room, text, date_time, user_id, room_id) " + "values (" + "'" + message.getAuthor().getLogin() + "'" + ", " +
                "'" + message.getRoom().getName() + "'" + ", " +
                "'" + message.getText() + "'" + ", " +
                "'" + message.getDateTime().toLocalDateTime() + "'" + ", " + message.getAuthor().getId() + ", " + message.getRoom().getId() +
                ')';
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(SQL_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            int rows = pst.executeUpdate();
            if (rows == 0) {
                System.err.println("Creating message failed");
            }
            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    message.setId(generatedKeys.getLong(1));
                } else {
                    System.err.println("Creating message failed in getGeneratedKeys()");
                }
            }
        } catch (SQLTimeoutException e) {
            throw new SQLTimeoutException();
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Author or User key is not present in table");
        }
    }

    @Override
    public void update(Message message) {
        if (message == null) throw new NotUpdatedEntityException("Message is null");
        String SQL_QUERY = "update messages set (author, room, text, date_time) = (?, ?, ?, ?) where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(SQL_QUERY)) {
            pst.setString(1, message.getAuthor().getLogin());
            pst.setString(2, message.getRoom().getName());
            pst.setString(3, message.getText());
            pst.setTimestamp(4, message.getDateTime());
            pst.setLong(5, message.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new NotUpdatedEntityException();
        }
    }
}
