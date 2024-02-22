package com.solvd.carina.demo.mobile.gui.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.enums.SortOption;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class SortingComponentBase extends AbstractUIObject {

    public SortingComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getSortItem();

    public void chooseItem(SortOption sortOption) {
        getSortItem().format(sortOption.getValue()).click();
    }
}
