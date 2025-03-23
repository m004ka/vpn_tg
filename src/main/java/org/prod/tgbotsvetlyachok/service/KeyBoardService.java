package org.prod.tgbotsvetlyachok.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyBoardService {

    public InlineKeyboardMarkup getBuyMarkup() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> but = new ArrayList<>();
        List<InlineKeyboardButton> but2 = new ArrayList<>();
        List<InlineKeyboardButton> but3 = new ArrayList<>();
        List<InlineKeyboardButton> but4 = new ArrayList<>();
        List<InlineKeyboardButton> but5 = new ArrayList<>();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        InlineKeyboardButton months = new InlineKeyboardButton();
        months.setText("199 руб на месяц");
        months.setCallbackData("MONTHS");
        but.add(months);

        InlineKeyboardButton threeMoths = new InlineKeyboardButton();
        threeMoths.setText("499 руб на 3 месяца");
        threeMoths.setCallbackData("THREEMONTHS");
        but2.add(threeMoths);

        InlineKeyboardButton sixMoths = new InlineKeyboardButton();
        sixMoths.setText("799 руб на полгода");
        sixMoths.setCallbackData("SIXMONTHS");
        but3.add(sixMoths);

        InlineKeyboardButton year = new InlineKeyboardButton();
        year.setText("1499 руб на год");
        year.setCallbackData("YEAR");
        but4.add(year);

        InlineKeyboardButton home = new InlineKeyboardButton();
        home.setText("Выйти в главное меню");
        home.setCallbackData("MENU");
        but5.add(home);

        buttons.add(but);
        buttons.add(but2);
        buttons.add(but3);
        buttons.add(but4);
        buttons.add(but5);

        keyboardMarkup.setKeyboard(buttons);
        return keyboardMarkup;
    }
}
