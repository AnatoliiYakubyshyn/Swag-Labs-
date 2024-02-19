package com.solvd.carina.demo.mobile.gui.pages.android;


import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement marker;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }
}
