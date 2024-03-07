package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.AboutWebPageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutWebPageBase.class)
public class AboutWebPage extends AboutWebPageBase {

    public AboutWebPage(WebDriver driver) {
        super(driver);
        setParametersForOpening();
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
    }

}
