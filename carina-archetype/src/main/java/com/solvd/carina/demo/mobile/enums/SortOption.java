package com.solvd.carina.demo.mobile.enums;

public enum SortOption {

    A_TO_Z("Name (A to Z)"),

    Z_TO_A("Name (Z to A)"),

    LOW_TO_HIGH("Price (low to high)"),

    HIGH_TO_LOW("Price (high to low)");

    private final String value;

    SortOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
