package org.prod.tgbotsvetlyachok.service.front.keyBoards;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadKeyBoardService {

    public InlineKeyboardMarkup getDownloadKeyboard() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();


        InlineKeyboardButton buttonIphone = new InlineKeyboardButton();
        buttonIphone.setText("📱 iPhone");
        buttonIphone.setUrl("https://apps.apple.com/ru/app/streisand/id6450534064");

        InlineKeyboardButton buttonAndroid = new InlineKeyboardButton();
        buttonAndroid.setText("🤖 Android");
        buttonAndroid.setUrl("https://play.google.com/store/apps/details?id=com.v2ray.ang&pli=1");


        InlineKeyboardButton buttonWindows = new InlineKeyboardButton();
        buttonWindows.setText("💻 Windows");
        buttonWindows.setUrl("https://github.com/hiddify/hiddify-next/releases/download/v2.5.7/Hiddify-Windows-Setup-x64.exe");

        InlineKeyboardButton buttonMac = new InlineKeyboardButton();
        buttonMac.setText("🍏 MacOS");
        buttonMac.setUrl("https://apps.apple.com/us/app/streisand/id6450534064?l=ru");


        InlineKeyboardButton buttonHuawei = new InlineKeyboardButton();
        buttonHuawei.setText("☎ Huawei");
        buttonHuawei.setUrl("https://github.com/2dust/v2rayNG/releases/download/1.8.5/v2rayNG_1.8.5.apk");


        InlineKeyboardButton buttonProfile = new InlineKeyboardButton();
        buttonProfile.setText("👤 Личный кабинет");
        buttonProfile.setCallbackData("MENU");


        buttons.add(List.of(buttonIphone, buttonAndroid));
        buttons.add(List.of(buttonWindows, buttonMac));
        buttons.add(List.of(buttonHuawei));
        buttons.add(List.of(buttonProfile));

        keyboardMarkup.setKeyboard(buttons);
        return keyboardMarkup;
    }

}
