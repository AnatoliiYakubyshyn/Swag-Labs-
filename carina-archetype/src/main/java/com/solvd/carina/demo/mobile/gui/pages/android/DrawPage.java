package com.solvd.carina.demo.mobile.gui.pages.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class DrawPage extends DrawPageBase implements IAndroidCommonContentPages {

    @ExtendedFindBy(image = "images/circle.png")
    private ExtendedWebElement pictureElement;

    public DrawPage(WebDriver driver) {
        super(driver);
    }

}
