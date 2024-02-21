package com.solvd.carina.demo.mobile.enums;

public enum UserType {

    STANDARD("standard"),

    LOCKED_OUT("locked_out"),

    PROBLEM("problem"),

    INVALID("invalid");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
