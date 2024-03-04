package com.solvd.carina.demo.mobile.gui.pages.android;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import com.solvd.carina.demo.mobile.gui.components.android.SortingComponent;
import com.solvd.carina.demo.mobile.gui.components.android.ItemComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.pojo.Item;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class ProductsPage extends ProductsPageBase implements IAndroidCommonContentPages {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement marker;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement sortingIcon;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/..")
    private SortingComponent sortComponent;

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Service | Privacy Policy']")
    private ExtendedWebElement endOfPageMarker;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Item'])[%d]")
    private ItemComponent item;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<Item> getListItems() {
        List<Item> items = new ArrayList<>();
        int k = 0;
        int remeberys = 0;
        int remeberye = 0;
        while (!endOfPageMarker.isPresent(1)) {
            for (int i = 1; i <= 2; i++) {
                if (getItem().getRootExtendedElement().format(i).isPresent()) {
                    items.add(new Item(getItem().getTitle(), getItem().getPrice()));
                }
            }

            int starty = getItem().getRootExtendedElement().getSize().getHeight()
                    + getItem().getRootExtendedElement().getLocation().getY();
            int endy = getItem().getRootExtendedElement().getLocation().getY() - 150;
            swipe(0, starty,
                    0, endy, 5000);
            k++;
            remeberye = endy;
            remeberys = starty;
        }
        //swiping back to the start of the view
        for (int i = 0; i < 3*k;i++) {
            swipeDown(1,1000);
        }
        return items;
    }
}
