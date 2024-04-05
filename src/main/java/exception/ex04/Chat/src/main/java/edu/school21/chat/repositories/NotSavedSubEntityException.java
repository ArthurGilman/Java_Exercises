package edu.school21.chat.repositories;

public class NotSavedSubEntityException extends SQLChatException {

    public NotSavedSubEntityException(String message) {
        super(message);
    }
}
