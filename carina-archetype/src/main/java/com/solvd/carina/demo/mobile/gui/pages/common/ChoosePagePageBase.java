package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.factories.PageFactory;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class ChoosePagePageBase extends AbstractPage {
    public ChoosePagePageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getDagger();

    protected abstract ExtendedWebElement getPageOption();


    public ICommonContent choosePage(PageOption pageOption) {
        getPageOption().format(pageOption.getValue()).click();
        return new PageFactory().getPage(pageOption);
    }

    public void closeWindow() {
        getDagger().click();
    }
}
