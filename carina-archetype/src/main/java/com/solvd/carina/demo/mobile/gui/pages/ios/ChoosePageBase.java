package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

public class ChoosePageBase extends ChoosePagePageBase {

    public ChoosePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getDagger() {
        throw new NotImplementedException();
    }

    @Override
    protected ExtendedWebElement getPageOption() {
        throw new NotImplementedException();
    }
}
