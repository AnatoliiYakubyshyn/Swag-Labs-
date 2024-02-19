package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.AbstractTest;

public class LoginTest extends AbstractTest {

    @Test
    @TestCaseKey("AYA-1")
    public void testStandardUserWithoutAutoFilling() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        ProductsPageBase productsPageBase = loginPageBase.login(UserType.STANDARD,false);
        Assert.assertTrue(productsPageBase.isPageOpened(),"Product page is not opened");
    }
}
