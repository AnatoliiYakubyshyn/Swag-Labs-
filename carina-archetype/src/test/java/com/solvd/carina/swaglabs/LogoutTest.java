package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.AbstractTest;
import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePagePageBase;

public class LogoutTest extends AbstractTest {

    @Test
    @TestCaseKey("AYA-9")
    public void test() {
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        ChoosePagePageBase choosePageBase = productsPageBase.getHeaderMenu().clickHamburgerIcon();
        choosePageBase.choosePage(PageOption.LOG_OUT);
        LoginPageBase loginPageBase = initPage(LoginPageBase.class, getDriver());
        loginPageBase.assertPageOpened();
    }
}
