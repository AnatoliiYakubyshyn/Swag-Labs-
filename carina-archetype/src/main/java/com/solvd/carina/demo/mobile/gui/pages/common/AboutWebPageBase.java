package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class AboutWebPageBase extends AbstractPage {

    public AboutWebPageBase(WebDriver driver) {
        super(driver);
    }

    protected void setParametersForOpening() {
        setPageURL("https://saucelabs.com");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

}
