package edu.school21.chat.repositories;

public class SQLChatException extends RuntimeException {
    public SQLChatException() {
    }

    public SQLChatException(String message) {
        super(message);
    }
}
