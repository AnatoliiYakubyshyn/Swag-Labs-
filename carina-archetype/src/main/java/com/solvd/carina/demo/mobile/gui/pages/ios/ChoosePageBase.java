package com.solvd.carina.demo.mobile.gui.pages.ios;

import lombok.AccessLevel;
import lombok.Getter;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@Getter(AccessLevel.PROTECTED)
public class ChoosePageBase extends ChoosePagePageBase {

    @ExtendedFindBy(accessibilityId = "test-%s")
    private ExtendedWebElement pageOption;

    public ChoosePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getDagger() {
        throw new NotImplementedException();
    }
}
