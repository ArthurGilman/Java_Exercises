package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<ChatRoom> createdRooms;
    private List<ChatRoom> chatingRooms;

    public User() {
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(Long id, String login, String password, List<ChatRoom> createdRooms, List<ChatRoom> chatingRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.chatingRooms = chatingRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ChatRoom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<ChatRoom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<ChatRoom> getChatingRooms() {
        return chatingRooms;
    }

    public void setChatingRooms(List<ChatRoom> chatingRooms) {
        this.chatingRooms = chatingRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatingRooms=" + chatingRooms +
                '}';
    }
}
