package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> allMessages;

    public ChatRoom() {
    }

    public ChatRoom(Long id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        allMessages = new ArrayList<>();
    }

    public ChatRoom(Long id, String name, User owner, List<Message> allMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.allMessages = allMessages;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public List<Message> getAllMessages() {
        return allMessages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setAllMessages(List<Message> allMessages) {
        this.allMessages = allMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatRoom chatRoom = (ChatRoom) o;
        return Objects.equals(id, chatRoom.id) && Objects.equals(name, chatRoom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",creator=" + owner +
                ",messages= " + allMessages +
                '}';
    }
}
