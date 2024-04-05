package edu.school21.chat.repositories;

public class NotUpdatedEntityException extends SQLChatException {
    public NotUpdatedEntityException() {
    }

    public NotUpdatedEntityException(String message) {
        super(message);
    }
}
