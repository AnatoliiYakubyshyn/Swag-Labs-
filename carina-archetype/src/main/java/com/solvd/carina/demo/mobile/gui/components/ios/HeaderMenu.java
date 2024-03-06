package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.solvd.carina.demo.mobile.gui.pages.ios.ChoosePageBase;
import lombok.AccessLevel;
import lombok.Getter;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


@Getter(AccessLevel.PROTECTED)
public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement hamburgerIcon;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    protected ExtendedWebElement getCartIcon() {
        throw new NotImplementedException();
    }

    @Override
    protected ChoosePagePageBase getPage() {
        return new ChoosePageBase(getDriver());
    }
}
