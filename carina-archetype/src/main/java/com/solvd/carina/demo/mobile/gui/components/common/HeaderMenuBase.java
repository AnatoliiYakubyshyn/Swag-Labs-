package com.solvd.carina.demo.mobile.gui.components.common;


import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    protected abstract ExtendedWebElement getHamburgerIcon();

    protected abstract ExtendedWebElement getCartIcon();

    protected abstract ChoosePagePageBase getPage();

    public ChoosePagePageBase clickHamburgerIcon() {
        getHamburgerIcon().click();
        return getPage();
    }

}
