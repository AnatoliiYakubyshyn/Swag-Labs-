package com.solvd.carina.demo.mobile.enums;

public enum PageOption {

    PRODUCT_PAGE("ALL ITEMS"),
    WEB_VIEW("WEBVIEW"),

    ABOUT("ABOUT"),

    LOG_OUT("LOGOUT");

    private final String value;

    PageOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
