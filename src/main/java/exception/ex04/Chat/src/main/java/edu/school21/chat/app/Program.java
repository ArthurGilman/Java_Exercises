package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.UsersRepository;
import edu.school21.chat.repositories.UsersRepositoryJdbcImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.OFF);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jdbc");
        config.setUsername("postgres");
        config.setPassword("12345");
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(new HikariDataSource(config));
        List<User> users = usersRepository.findAll(0, 3);
        for (User u : users) {
            System.out.printf("ID: %d || Login : %s || Password : %s\n", u.getId(), u.getLogin(), u.getPassword());
            System.out.println("Chating rooms : ");
            for (ChatRoom room : u.getChatingRooms()) {
                System.out.println(room);
            }
            System.out.println();
            System.out.println("Created rooms : ");
            for (ChatRoom room : u.getCreatedRooms()) {
                System.out.println(room);
            }
            System.out.println();
            System.out.println("----------------------------------------------");
        }
    }
}
