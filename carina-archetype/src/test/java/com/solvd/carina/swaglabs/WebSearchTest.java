package com.solvd.carina.swaglabs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;

import java.lang.module.Configuration;

public class WebSearchTest extends AbstractTest {


    private void navigateToWebInIos() {
        pause(2);
        getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='banner']")).click();
    }
    @Test
    @TestCaseKey("AYA-7")
    public void testWebSearchIsSuccessful() {
        MobileContextUtils contextUtils = new MobileContextUtils();
        //contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        ChoosePagePageBase choosePageBase = productsPageBase.getHeaderMenu().clickHamburgerIcon();
        WebViewPageBase webViewPageBase = (WebViewPageBase) choosePageBase.choosePage(PageOption.WEB_VIEW);
        webViewPageBase.visitWebSite(R.TESTDATA.get("url"));
        if (R.CONFIG.get("capabilities.platformName").equalsIgnoreCase("ios")) {
            navigateToWebInIos();
            System.out.println("Hello");
        }
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        String curUrl = getDriver().getCurrentUrl();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        Assert.assertEquals(curUrl, R.TESTDATA.get("url_exp"));

    }
}
