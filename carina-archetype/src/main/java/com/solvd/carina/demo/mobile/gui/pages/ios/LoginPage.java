package com.solvd.carina.demo.mobile.gui.pages.ios;

import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.services.UserService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement userNameField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @ExtendedFindBy(accessibilityId = "test-%s")
    private ExtendedWebElement autoFillingOption;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getAutoFillingOption(UserType type) {
        return autoFillingOption.format(UserService.getUser(type).getUsername());
    }

}
