package org.prod.tgbotsvetlyachok.service.front.keyBoards;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyBoardService {

    public InlineKeyboardMarkup getMenuMarkup() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();


        InlineKeyboardButton buttonBuy = new InlineKeyboardButton();
        buttonBuy.setText("\uD83D\uDCB8 Купить дни доступа");
        buttonBuy.setCallbackData("BUY");

        InlineKeyboardButton buttonSetup = new InlineKeyboardButton();
        buttonSetup.setText("⚙\uFE0F Как настроить?");
        buttonSetup.setCallbackData("SETUP");

        InlineKeyboardButton buttonUpdate = new InlineKeyboardButton();
        buttonUpdate.setText("\uD83D\uDD04 Обновить");
        buttonUpdate.setCallbackData("MENU_UPDATE");

        InlineKeyboardButton buttonHelp = new InlineKeyboardButton();
        buttonHelp.setText("\uD83D\uDEA8 Помощь");
        buttonHelp.setUrl("https://t.me/Svetlyachok_support");

        InlineKeyboardButton buttonKey = new InlineKeyboardButton();
        buttonKey.setText("\uD83D\uDD11 Ключ");
        buttonKey.setCallbackData("KEY");

        InlineKeyboardButton buttonDownload = new InlineKeyboardButton();
        buttonDownload.setText("\uD83D\uDD04 Скачать VPN");
        buttonDownload.setCallbackData("DOWNLOAD");

        buttons.add(List.of(buttonBuy));
        buttons.add(List.of(buttonKey));
        buttons.add(List.of(buttonSetup, buttonDownload));
        buttons.add(List.of(buttonUpdate, buttonHelp));

        keyboardMarkup.setKeyboard(buttons);
        return keyboardMarkup;
    }

    public InlineKeyboardMarkup backKeyBoard(){
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> but = new ArrayList<>();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Назад");
        button.setCallbackData("MENU");
        but.add(button);
        buttons.add(but);
        keyboardMarkup.setKeyboard(buttons);

        return keyboardMarkup;
    }

    public InlineKeyboardMarkup backKeyBoardDeleteMess(){
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> but = new ArrayList<>();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Назад");
        button.setCallbackData("MENU_delete");
        but.add(button);
        buttons.add(but);
        keyboardMarkup.setKeyboard(buttons);

        return keyboardMarkup;
    }
}
