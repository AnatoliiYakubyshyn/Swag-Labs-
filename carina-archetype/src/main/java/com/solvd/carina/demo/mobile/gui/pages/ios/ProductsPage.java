package com.solvd.carina.demo.mobile.gui.pages.ios;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.ios.SortingComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class ProductsPage extends ProductsPageBase {

    @ExtendedFindBy(iosPredicate = "label == 'PRODUCTS'")
    private ExtendedWebElement marker;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement sortingIcon;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name='Selector container'])[1]")
    private SortingComponent sortComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
}
