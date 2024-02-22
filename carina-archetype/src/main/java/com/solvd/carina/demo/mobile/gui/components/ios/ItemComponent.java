package com.solvd.carina.demo.mobile.gui.components.ios;

import lombok.Getter;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.common.ItemComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@Getter
public class ItemComponent extends ItemComponentBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Price']")
    private ExtendedWebElement priceField;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title']")
    private ExtendedWebElement titleField;

    public ItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
