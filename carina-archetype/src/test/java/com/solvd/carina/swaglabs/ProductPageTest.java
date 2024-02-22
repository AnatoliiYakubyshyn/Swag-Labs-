package com.solvd.carina.swaglabs;

import com.solvd.carina.demo.mobile.enums.SortOption;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.AbstractTest;

public class ProductPageTest extends AbstractTest {
    @Test
    @TestCaseKey("AYA-6")
    public void testSorting() {
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        SortingComponentBase sortingComponentBase = productsPageBase.clickSortingIcon();
        sortingComponentBase.chooseItem(SortOption.A_TO_Z);
    }
}
