package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @ExtendedFindBy(iosPredicate = "label == 'PRODUCTS'")
    private ExtendedWebElement marker;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }
}
