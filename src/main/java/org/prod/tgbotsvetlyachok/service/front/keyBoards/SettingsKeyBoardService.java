package org.prod.tgbotsvetlyachok.service.front.keyBoards;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SettingsKeyBoardService {

    public InlineKeyboardMarkup setupMarkup() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        InlineKeyboardButton buttonIPhone = new InlineKeyboardButton();
        buttonIPhone.setText("iPhone/iPad 🍏");
        buttonIPhone.setCallbackData("IPHONE");
        buttons.add(Collections.singletonList(buttonIPhone));

        InlineKeyboardButton buttonAndroid = new InlineKeyboardButton();
        buttonAndroid.setText("Android 🤖");
        buttonAndroid.setCallbackData("ANDROID");
        buttons.add(Collections.singletonList(buttonAndroid));


        InlineKeyboardButton buttonMac = new InlineKeyboardButton();
        buttonMac.setText("Mac 🍎");
        buttonMac.setCallbackData("MAC");
        buttons.add(Collections.singletonList(buttonMac));

        InlineKeyboardButton buttonWin = new InlineKeyboardButton();
        buttonWin.setText("Windows 🪟");
        buttonWin.setCallbackData("WIN");
        buttons.add(Collections.singletonList(buttonWin));

        InlineKeyboardButton buttonTv = new InlineKeyboardButton();
        buttonTv.setText("Телевизор 📺");
        buttonTv.setCallbackData("TV");
        buttons.add(Collections.singletonList(buttonTv));


        InlineKeyboardButton buttonBack = new InlineKeyboardButton();
        buttonBack.setText("Назад");
        buttonBack.setCallbackData("MENU");
        buttons.add(Collections.singletonList(buttonBack));

        keyboardMarkup.setKeyboard(buttons);
        return keyboardMarkup;
    }

}
