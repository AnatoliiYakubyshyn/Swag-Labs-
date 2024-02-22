package com.solvd.carina.demo.mobile.gui.components.ios;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@Getter(AccessLevel.PROTECTED)
public class SortingComponent extends SortingComponentBase {

    @ExtendedFindBy(iosPredicate = "label == '%s'")
    private ExtendedWebElement sortItem;

    public SortingComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
