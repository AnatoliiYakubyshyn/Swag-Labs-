package com.solvd.carina.demo.mobile.gui.pages.android;


import com.zebrunner.carina.utils.factory.DeviceType;
import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@Getter(AccessLevel.PROTECTED)
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase implements IAndroidCommonContentPages {

    @ExtendedFindBy(accessibilityId = "test-enter a https url here...")
    private ExtendedWebElement inputField;

    @ExtendedFindBy(accessibilityId = "test-GO TO SITE")
    private ExtendedWebElement goToSiteButton;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }
}
