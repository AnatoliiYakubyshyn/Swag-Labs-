package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawPageBase.class)
public class DrawPage extends DrawPageBase implements IIOSCommonContentPages {

    public DrawPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getPictureElement() {
       throw new  NotImplementedException();
    }
}
