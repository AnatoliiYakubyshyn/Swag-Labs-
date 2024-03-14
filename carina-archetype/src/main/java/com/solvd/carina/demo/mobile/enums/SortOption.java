package com.solvd.carina.demo.mobile.enums;

import java.util.Comparator;

import com.solvd.carina.demo.mobile.pojo.Item;

public enum SortOption {

    A_TO_Z("Name (A to Z)", Comparator.comparing(Item::getTitle)),

    Z_TO_A("Name (Z to A)", (a, b) -> -a.getTitle().compareTo(b.getTitle())),

    LOW_TO_HIGH("Price (low to high)", Comparator.comparing(Item::getPrice)),

    HIGH_TO_LOW("Price (high to low)", (a, b) -> -Double.compare(a.getPrice(), b.getPrice()));

    private final String value;

    private final Comparator<Item> comparator;

    SortOption(String value, Comparator<Item> comparator) {
        this.value = value;
        this.comparator = comparator;
    }

    public String getValue() {
        return value;
    }

    public Comparator<Item> getComparator() {
        return comparator;
    }
}
