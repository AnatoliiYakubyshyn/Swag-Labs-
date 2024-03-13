package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.enums.PageOption;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class ChoosePageBase extends AbstractPage {
    public ChoosePageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getDagger();

    protected abstract ExtendedWebElement getPageOption();

    private AbstractPage getPage(PageOption pageOption) {
        switch (pageOption) {
            case WEB_VIEW:
                return initPage(WebViewPageBase.class);
            case ABOUT:
                return initPage(AboutWebPageBase.class);
            case DRAWING:
                return initPage(DrawPageBase.class);
            default:
                return initPage(ProductListPageBase.class);
        }
    }

    public AbstractPage choosePage(PageOption pageOption) {
        getPageOption().format(pageOption.getValue()).click();
        return getPage(pageOption);
    }

    public void closeWindow() {
        getDagger().click();
    }
}
