package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ICommonContent;
import com.zebrunner.carina.webdriver.IDriverPool;
import com.solvd.carina.demo.mobile.gui.components.ios.HeaderMenu;

public interface IIOSCommonContentPages extends ICommonContent, IDriverPool {
    @Override
    default HeaderMenuBase getHeaderMenu() {
       return new HeaderMenu(getDriver(),getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='headerContainer']//..")));
    }
}
