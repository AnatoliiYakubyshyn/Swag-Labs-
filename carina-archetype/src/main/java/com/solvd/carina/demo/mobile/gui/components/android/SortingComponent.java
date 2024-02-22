package com.solvd.carina.demo.mobile.gui.components.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.common.SortingComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@Getter(AccessLevel.PROTECTED)
public class SortingComponent extends SortingComponentBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortItem;

    public SortingComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
