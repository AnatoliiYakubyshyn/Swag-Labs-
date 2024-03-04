package com.solvd.carina.demo.mobile.gui.pages.ios;


import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import com.solvd.carina.demo.mobile.gui.components.ios.SortingComponent;
import com.solvd.carina.demo.mobile.gui.components.ios.ItemComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.pojo.Item;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class ProductsPage extends ProductsPageBase implements IIOSCommonContentPages {

    @ExtendedFindBy(iosPredicate = "label == 'PRODUCTS'")
    private ExtendedWebElement marker;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement sortingIcon;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name='Selector container'])[1]")
    private SortingComponent sortComponent;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name='test-Item'])[%d]")
    private ItemComponent item;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<Item> getListItems() {
        List<Item> items = new ArrayList<>();
        int k = 0;
        while (getItem().getRootExtendedElement().format(2 * k + 1).isPresent()) {
            for (int i = 1; i <= 2; i++) {
                if (getItem().getRootExtendedElement().format(2 * k + i).isPresent()) {
                    items.add(new Item(getItem().getTitle(), getItem().getPrice()));
                }
            }

            int starty = getItem().getRootExtendedElement().getSize().getHeight()
                    + getItem().getRootExtendedElement().getLocation().getY();
            int endy = getItem().getRootExtendedElement().getLocation().getY();
            if (getItem().getRootExtendedElement().format(2 * (k + 1) + 1).isPresent()) {
                swipe(0, starty,
                        0, endy, 5000);
            }
            k++;

        }
        k--;
        //swiping back to the start of the view
        for (int i = 0; i <= k; i++) {
            getItem().getRootExtendedElement().format(2 * (k - i) + 1);
            int endy = getItem().getRootExtendedElement().getSize().getHeight()
                    + getItem().getRootExtendedElement().getLocation().getY();
            int starty = getItem().getRootExtendedElement().getLocation().getY();
            swipe(0, starty,
                    0, endy, 1500);
        }
        return items;
    }
}
