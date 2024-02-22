package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductsPageBase extends AbstractPage {

    public ProductsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getMarker());
    }

    protected abstract ExtendedWebElement getSortingIcon();

    protected abstract ExtendedWebElement getMarker();

    protected abstract SortingComponentBase getSortComponent();

    public SortingComponentBase clickSortingIcon() {
        getSortingIcon().click();
        return getSortComponent();
    }
}
