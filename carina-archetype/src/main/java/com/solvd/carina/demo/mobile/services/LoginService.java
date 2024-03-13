package com.solvd.carina.demo.mobile.services;

import org.testng.Assert;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;

public class LoginService {

    public static ProductListPageBase login(LoginPageBase loginPageBase, boolean useAutoFilling) {
        ProductListPageBase productsPageBase = loginPageBase.login(UserType.STANDARD, useAutoFilling);
        Assert.assertTrue(productsPageBase.isPageOpened(), "Product page is not opened");
        return productsPageBase;
    }
}
