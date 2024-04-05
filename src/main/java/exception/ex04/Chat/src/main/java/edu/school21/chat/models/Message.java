package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private ChatRoom room;
    private String text;
    private Timestamp dateTime;

    public Message() {
    }

    public Message(Long id, User author, ChatRoom room, String text, Timestamp dateTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public ChatRoom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(ChatRoom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(author, message.author) && Objects.equals(room, message.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room);
    }

    @Override
    public String toString() {
        return "Message : {\n" +
                "id=" + id +
                ",\nauthor=" + author +
                ", \nroom=" + room +
                ", \ntext='" + text + '\'' +
                ", \ndateTime=" + dateTime +
                "\n}";
    }
}
