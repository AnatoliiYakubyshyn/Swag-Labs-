package com.solvd.carina.demo.mobile.gui.pages.common;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.components.common.ItemComponentBase;
import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.solvd.carina.demo.mobile.enums.SortOption;
import com.solvd.carina.demo.mobile.pojo.Item;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;


public abstract class ProductListPageBase extends AbstractPage implements IMobileUtils, ICommonContent {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getMarker());
    }

    protected abstract ExtendedWebElement getSortingIcon();

    protected abstract ItemComponentBase getItem();

    protected abstract ExtendedWebElement getMarker();

    protected abstract SortingComponentBase getSortComponent();


    public SortingComponentBase clickSortingIcon() {
        getSortingIcon().click();
        return getSortComponent();
    }

    public abstract List<Item> getListItems();

    public void checkCorrectSortingResult(SoftAssert softAssert, SortOption sortOption) {
        SortingComponentBase sortingComponentBase = clickSortingIcon();
        sortingComponentBase.chooseItem(sortOption);
        List<Item> products = getListItems();
        softAssert.assertEquals(products,products.stream().sorted(sortOption.getComparator()).collect(Collectors.toList()),
                sortOption.getValue()+" is wrong");
    }
}
