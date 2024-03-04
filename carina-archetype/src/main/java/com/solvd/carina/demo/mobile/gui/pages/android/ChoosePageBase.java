package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChoosePageBase.class)
public class ChoosePageBase extends ChoosePagePageBase {

    public ChoosePageBase(WebDriver driver) {
        super(driver);
    }
}
