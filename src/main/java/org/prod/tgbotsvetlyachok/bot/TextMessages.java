package org.prod.tgbotsvetlyachok.bot;

import lombok.Getter;

@Getter
public enum TextMessages {
    START_MESSAGE_TEXT(""),
    PRICE_MESSAGE_TEXT(""),
    PROFILE_MESSAGE_TEXT(""),
    DOWNLOAD_VPN_TEXT(""),
    SETTINGS_VPN_TEXT(""),
    GET_KEY_VPN_TEXT("");

    private final String text;
    TextMessages(String text){
        this.text = text;
    }
}
