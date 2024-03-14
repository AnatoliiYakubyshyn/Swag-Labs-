package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.solvd.carina.demo.utils.MobileContextUtils;
import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.core.AbstractTest;

public class BaseTest extends AbstractTest {

    public ProductListPageBase loginAsStandardUser(boolean useAutoFilling) {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        ProductListPageBase productsPageBase = loginPageBase.login(UserType.STANDARD, useAutoFilling);
        Assert.assertTrue(productsPageBase.isPageOpened(), "Product page is not opened");
        return productsPageBase;
    }

    @BeforeMethod
    public void setUp() {
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
    }
}
