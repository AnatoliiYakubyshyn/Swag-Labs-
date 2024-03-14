package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.solvd.carina.demo.mobile.gui.pages.common.AboutWebPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;

public class WebSearchTest extends BaseTest {

    @Test
    @TestCaseKey("AYA-7")
    public void testWebSearchIsSuccessful() {
        ProductListPageBase productListPageBase = loginAsStandardUser(false);
        ChoosePageBase choosePageBase = productListPageBase.getHeaderMenu().clickHamburgerIcon();
        WebViewPageBase webViewPageBase = (WebViewPageBase) choosePageBase.choosePage(PageOption.WEB_VIEW);
        webViewPageBase.visitWebSite(R.TESTDATA.get("url"));
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        String curUrl = getDriver().getCurrentUrl();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        Assert.assertEquals(curUrl, R.TESTDATA.get("url_exp"));
    }

    @Test
    @TestCaseKey("AYA-8")
    public void testAboutSection() {
        ProductListPageBase productListPageBase = loginAsStandardUser(false);
        ChoosePageBase choosePageBase = productListPageBase.getHeaderMenu().clickHamburgerIcon();
        AboutWebPageBase aboutWebPage = (AboutWebPageBase) choosePageBase.choosePage(PageOption.ABOUT);
        boolean isPageOpened = aboutWebPage.isPageOpened();
        Assert.assertTrue(isPageOpened);
    }
}
