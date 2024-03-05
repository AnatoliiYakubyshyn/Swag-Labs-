package com.solvd.carina.demo.mobile.gui.pages.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@Getter (AccessLevel.PROTECTED)
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChoosePageBase.class)
public class ChoosePageBase extends ChoosePagePageBase {

    @FindBy(xpath = "//*[contains(@text,'%s')]")
    private ExtendedWebElement pageOption;

    public ChoosePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getDagger() {
       throw new NotImplementedException();
    }

}
