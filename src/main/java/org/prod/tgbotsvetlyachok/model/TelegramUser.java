package org.prod.tgbotsvetlyachok.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TelegramUser {
    private Long userId;
    private Long chatId;
    private String firstName;
    private String lastName;
    private String username;

    private String link;

    private Timestamp registeredAt;
}