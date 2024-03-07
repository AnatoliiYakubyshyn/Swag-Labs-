package com.solvd.carina.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.common.AboutWebPageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;
import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;

public class WebSearchTest extends BaseTest {

    private ChoosePagePageBase choosePageBase;

    private MobileContextUtils contextUtils;

    @BeforeMethod
    public void commonActions() {
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        choosePageBase = productsPageBase.getHeaderMenu().clickHamburgerIcon();
        contextUtils = new MobileContextUtils();
    }

    @Test
    @TestCaseKey("AYA-7")
    public void testWebSearchIsSuccessful() {
        WebViewPageBase webViewPageBase = (WebViewPageBase) choosePageBase.choosePage(PageOption.WEB_VIEW);
        webViewPageBase.visitWebSite(R.TESTDATA.get("url"));
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        String curUrl = getDriver().getCurrentUrl();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        Assert.assertEquals(curUrl, R.TESTDATA.get("url_exp"));
    }

    @Test
    @TestCaseKey("AYA-8")
    public void testAboutSection() {
        AboutWebPageBase aboutWebPage = (AboutWebPageBase) choosePageBase.choosePage(PageOption.ABOUT);
        boolean isPageOpened = aboutWebPage.isPageOpened();
        Assert.assertTrue(isPageOpened);
    }
}
