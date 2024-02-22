package com.solvd.carina.demo.mobile.gui.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class ItemComponentBase extends AbstractUIObject {

    public ItemComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getPriceField();

    protected abstract ExtendedWebElement getTitleField();

    public String getTitle() {
        return getTitleField().getText();
    }

    public double getPrice() {
        return Double.parseDouble(getPriceField().getText().substring(1));
    }
}
