package com.solvd.carina.demo.mobile.gui.pages.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@Getter(AccessLevel.PROTECTED)
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase implements IAndroidCommonContentPages {

    public WebViewPage(WebDriver driver) {
        super(driver);
    }
}
