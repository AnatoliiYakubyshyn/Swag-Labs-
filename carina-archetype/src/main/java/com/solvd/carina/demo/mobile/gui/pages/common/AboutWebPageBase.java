package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class AboutWebPageBase extends AbstractPage {

    @FindBy(xpath = "//img[contains(@alt,'Saucelabs') and contains(@src,'logo')]")
    private ExtendedWebElement logo;

    public AboutWebPageBase(WebDriver driver) {
        super(driver);
    }

    protected void setParametersForOpening() {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
    }

}
