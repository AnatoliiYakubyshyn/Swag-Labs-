package com.solvd.carina.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePageBase;
import org.testng.annotations.Test;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;

public class LogoutTest extends BaseTest {

    @Test
    @TestCaseKey("AYA-9")
    public void test() {
        ProductListPageBase productsPageBase = loginAsStandardUser(false);
        ChoosePageBase choosePageBase = productsPageBase.getHeaderMenu().clickHamburgerIcon();
        choosePageBase.choosePage(PageOption.LOG_OUT);
        LoginPageBase loginPageBase = initPage(LoginPageBase.class, getDriver());
        loginPageBase.assertPageOpened();
    }
}
