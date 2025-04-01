package org.prod.tgbotsvetlyachok.dto;

import lombok.Builder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
public class TelegramUserDTO {

    private Long chatId;
    private String firstName;
    private String lastName;
    private String username;

    private String link;

    private Timestamp registeredAt;

    public static TelegramUserDTO toUserDTO(Update update){
        TelegramUserDTO dto = TelegramUserDTO.builder()
                .chatId(update.getMessage().getChatId())
                .firstName(update.getMessage().getFrom().getFirstName())
                .lastName(update.getMessage().getFrom().getLastName())
                .username(update.getMessage().getFrom().getUserName())
                .link("https://t.me/" + update.getMessage().getFrom().getUserName())
                .registeredAt(Timestamp.from(Instant.now()))
                .build();

        return validateDTO(dto);
    }

    private static TelegramUserDTO validateDTO(TelegramUserDTO telegramUserDTO){
        if(telegramUserDTO.firstName == null) telegramUserDTO.setFirstName("notSet");
        if(telegramUserDTO.lastName == null) telegramUserDTO.setFirstName("notSet");
        if(telegramUserDTO.username == null) telegramUserDTO.setFirstName("notSet");
        return telegramUserDTO;
    }
}
