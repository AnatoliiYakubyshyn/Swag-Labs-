package com.solvd.carina.swaglabs;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.solvd.carina.demo.mobile.enums.SortOption;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class ProductPageTest extends BaseTest {
    @Test
    @TestCaseKey("AYA-6")
    public void testSorting() {
        ProductListPageBase productsPageBase = loginAsStandardUser(false);
        SoftAssert softAssert = new SoftAssert();
        SortOption[] sortOptions = {SortOption.A_TO_Z, SortOption.Z_TO_A, SortOption.LOW_TO_HIGH,
                SortOption.HIGH_TO_LOW};
        for (SortOption sortOption : sortOptions) {
            productsPageBase.checkCorrectSortingResult(softAssert, sortOption);
        }
        softAssert.assertAll();

    }
}
