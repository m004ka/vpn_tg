package org.prod.tgbotsvetlyachok.service.front.messages;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.bot.TelegramBot;
import org.prod.tgbotsvetlyachok.service.front.MessageService;
import org.prod.tgbotsvetlyachok.service.front.keyBoards.DownloadKeyBoardService;
import org.prod.tgbotsvetlyachok.service.front.text.DownloadTextMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class DownloadMessages {

    private final MessageService messageService;
    private final DownloadTextMessageService text;
    private final DownloadKeyBoardService keyBoard;
    private final TelegramBot telegramBot;

    public void downloadMessage(Update update){
        EditMessageText message = new EditMessageText();
        Long id = messageService.getChatId(update);
        int messId = messageService.getIdLastBotMessage(update);

        message.setChatId(id);
        message.setMessageId(messId);
        message.setParseMode("MARKDOWN");
        message.setText(text.downloadText());
        message.setReplyMarkup(keyBoard.getDownloadKeyboard());

        telegramBot.sendMessage(message);
    }
}
