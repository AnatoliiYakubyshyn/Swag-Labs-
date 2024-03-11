package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.AboutWebPageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutWebPageBase.class)
public class AboutWebPage extends AboutWebPageBase {

    public AboutWebPage(WebDriver driver) {
        super(driver);
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        setParametersForOpening();
    }

}
