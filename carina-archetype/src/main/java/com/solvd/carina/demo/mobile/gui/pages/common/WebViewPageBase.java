package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class WebViewPageBase extends AbstractPage implements ICommonContent {

    protected WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getInputField();

    protected abstract ExtendedWebElement getGoToSiteButton();

    public void visitWebSite(String url) {
        getInputField().type(url);
        getGoToSiteButton().click();
    }
}
