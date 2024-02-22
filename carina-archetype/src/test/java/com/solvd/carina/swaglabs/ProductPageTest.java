package com.solvd.carina.swaglabs;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.carina.demo.mobile.enums.SortOption;
import com.solvd.carina.demo.mobile.pojo.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.asserts.SoftAssert;

public class ProductPageTest extends AbstractTest {
    @Test
    @TestCaseKey("AYA-6")
    public void testSorting() {
        LoginTest loginTest = new LoginTest();
        ProductsPageBase productsPageBase = loginTest.testStandardUser(false);
        SortingComponentBase sortingComponentBase = productsPageBase.clickSortingIcon();
        sortingComponentBase.chooseItem(SortOption.A_TO_Z);
        List<Item> products = productsPageBase.getListItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(products, products.stream().sorted(
                        Comparator.comparing(Item::getTitle)).
                collect(Collectors.toList()), "A_TO_Z sorting is incorrect");
        sortingComponentBase = productsPageBase.clickSortingIcon();
        sortingComponentBase.chooseItem(SortOption.Z_TO_A);
        products = productsPageBase.getListItems();
        softAssert.assertEquals(products, products.stream().sorted(
                        (a, b) -> -a.getTitle().compareTo(b.getTitle())).
                collect(Collectors.toList()), "Z_TO_A sorting is incorrect");
        sortingComponentBase = productsPageBase.clickSortingIcon();
        sortingComponentBase.chooseItem(SortOption.LOW_TO_HIGH);
        products = productsPageBase.getListItems();
        softAssert.assertEquals(products, products.stream().sorted(
                        Comparator.comparing(Item::getPrice)).
                collect(Collectors.toList()), "Low to high sorting is incorrect");
        sortingComponentBase = productsPageBase.clickSortingIcon();
        sortingComponentBase.chooseItem(SortOption.HIGH_TO_LOW);
        products = productsPageBase.getListItems();
        softAssert.assertEquals(products, products.stream().sorted(
                        (a, b) -> -Double.compare(a.getPrice(), b.getPrice())).
                collect(Collectors.toList()), "High to Low sorting is incorrect");
        softAssert.assertAll();

    }
}
