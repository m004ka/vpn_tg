package org.prod.tgbotsvetlyachok.service.front.keyBoards;

import lombok.RequiredArgsConstructor;
import org.prod.tgbotsvetlyachok.bot.Period;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service //todo Логирование и сделать логику сохранения почты
@RequiredArgsConstructor
public class BuyKeyBoardService {

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

    public InlineKeyboardMarkup checkKeyBoard(){
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> but = new ArrayList<>();
        List<InlineKeyboardButton> but2 = new ArrayList<>();
        InlineKeyboardButton YesCheck = new InlineKeyboardButton();
        YesCheck.setText("Да, нужен");
        YesCheck.setCallbackData("RECEIPT_TRUE");
        but.add(YesCheck);
        InlineKeyboardButton NoCheck = new InlineKeyboardButton();
        NoCheck.setText("Нет");
        NoCheck.setCallbackData("RECEIPT_FALSE");
        but.add(NoCheck);
        InlineKeyboardButton home = new InlineKeyboardButton();
        home.setText("Назад");
        home.setCallbackData("BUY");
        but2.add(home);
        buttons.add(but);
        buttons.add(but2);
        keyboardMarkup.setKeyboard(buttons);

        return keyboardMarkup;
    }

    public InlineKeyboardMarkup backKeyBoard(){
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> but = new ArrayList<>();
        List<InlineKeyboardButton> but2 = new ArrayList<>();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton NoCheck = new InlineKeyboardButton();
        NoCheck.setText("Передумал, чек не нужен");
        NoCheck.setCallbackData("RECEIPT_FALSE");
        but2.add(NoCheck);
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Назад");
        button.setCallbackData("MENU");
        but.add(button);
        buttons.add(but);
        buttons.add(but2);
        keyboardMarkup.setKeyboard(buttons);

        return keyboardMarkup;
    }


}
