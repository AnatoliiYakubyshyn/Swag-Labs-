package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class LoginTest extends BaseTest {

    public void testLockedOutUser(boolean useAutoFilling) {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login(UserType.LOCKED_OUT, useAutoFilling);
        Assert.assertTrue(loginPageBase.isMessageDisplayed("Sorry, this user has been locked out."));
    }

    @Test
    @TestCaseKey("AYA-1")
    public void testStandardUserWithoutAutoFilling() {
        loginAsStandardUser(false);
    }

    @Test
    @TestCaseKey("AYA-2")
    public void testStandardUserWithAutoFilling() {
        loginAsStandardUser(true);
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
