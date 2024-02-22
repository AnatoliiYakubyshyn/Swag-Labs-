package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.AbstractTest;

public class LoginTest extends AbstractTest {

    public ProductsPageBase testStandardUser(boolean useAutoFilling) {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        ProductsPageBase productsPageBase = loginPageBase.login(UserType.STANDARD, useAutoFilling);
        Assert.assertTrue(productsPageBase.isPageOpened(), "Product page is not opened");
        return productsPageBase;
    }

    public void testLockedOutUser(boolean useAutoFilling) {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login(UserType.LOCKED_OUT, useAutoFilling);
        Assert.assertTrue(loginPageBase.isMessageDisplayed("Sorry, this user has been locked out."));
    }

    @Test
    @TestCaseKey("AYA-1")
    public void testStandardUserWithoutAutoFilling() {
        testStandardUser(false);
    }

    @Test
    @TestCaseKey("AYA-2")
    public void testStandardUserWithAutoFilling() {
        testStandardUser(true);
    }

    @Test
    @TestCaseKey("AYA-3")
    public void testLockedOutUserWithAutoFilling() {
        testLockedOutUser(true);
    }

    @Test
    @TestCaseKey("AYA-4")
    public void testLockedOutUserWithOutAutoFilling() {
        testLockedOutUser(false);
    }

    @Test
    @TestCaseKey("AYA-5")
    public void testInvalidUserErrorMessage() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login(UserType.INVALID, false);
        Assert.assertTrue(loginPageBase.isMessageDisplayed("Username and password do not match any user in this service."));
    }


}
