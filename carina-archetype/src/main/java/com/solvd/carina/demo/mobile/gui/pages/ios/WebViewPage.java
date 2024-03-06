package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.android.IAndroidCommonContentPages;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase implements IAndroidCommonContentPages {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }
}
