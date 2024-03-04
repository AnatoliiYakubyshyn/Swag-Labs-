package com.solvd.carina.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class WebSearchTest extends AbstractTest {

    @Test
    @TestCaseKey("AYA-7")
    public void testWebSearchIsSuccessful() {
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        productsPageBase.getHeaderMenu().clickHamburgerIcon();
    }
}
