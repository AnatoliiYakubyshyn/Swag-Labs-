package com.solvd.carina.demo.mobile.gui.components.common;


import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.interactions.Actions;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getHamburgerIcon();

    protected abstract ExtendedWebElement getCartIcon();

    protected abstract ChoosePageBase getPage();

    public ChoosePageBase clickHamburgerIcon() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getHamburgerIcon().getElement(),10,10).click().perform();
        return getPage();
    }

}
