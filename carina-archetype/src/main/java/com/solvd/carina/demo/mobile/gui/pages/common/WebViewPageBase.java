package com.solvd.carina.demo.mobile.gui.pages.common;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@Getter(AccessLevel.PROTECTED)
public abstract class WebViewPageBase extends AbstractPage implements ICommonContent {

    @ExtendedFindBy(accessibilityId = "test-enter a https url here...")
    private ExtendedWebElement inputField;

    @ExtendedFindBy(accessibilityId = "test-GO TO SITE")
    private ExtendedWebElement goToSiteButton;

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }


    public void visitWebSite(String url) {
        getInputField().type(url);
        getGoToSiteButton().click();
    }
}
