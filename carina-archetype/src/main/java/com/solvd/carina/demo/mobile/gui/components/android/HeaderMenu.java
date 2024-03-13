package com.solvd.carina.demo.mobile.gui.components.android;


import lombok.AccessLevel;
import lombok.Getter;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.android.ChoosePage;
import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@Getter(AccessLevel.PROTECTED)
public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement hamburgerIcon;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    protected ExtendedWebElement getCartIcon() {
        throw new NotImplementedException();
    }

    @Override
    protected ChoosePageBase getPage() {
        return new ChoosePage(getDriver());
    }
}
