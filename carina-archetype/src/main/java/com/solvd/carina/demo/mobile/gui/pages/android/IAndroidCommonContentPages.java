package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.By;

import com.solvd.carina.demo.mobile.gui.components.android.HeaderMenu;
import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ICommonContent;
import com.zebrunner.carina.webdriver.IDriverPool;

public interface IAndroidCommonContentPages extends ICommonContent, IDriverPool {

    @Override
    default HeaderMenuBase getHeaderMenu() {
        By headerMenu = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/..");
        return new HeaderMenu(getDriver(),getDriver().findElement(headerMenu));
    }
}
