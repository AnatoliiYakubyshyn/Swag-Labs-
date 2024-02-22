package com.solvd.carina.demo.mobile.gui.pages.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.components.android.SortingComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement marker;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement sortingIcon;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/..")
    private SortingComponent sortComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
}
