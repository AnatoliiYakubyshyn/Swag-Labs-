package com.solvd.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.AccessLevel;
import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.services.UserService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
@Getter(AccessLevel.PROTECTED)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement userNameField;

    @ExtendedFindBy( accessibilityId= "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-%s']/android.widget.TextView")
    private ExtendedWebElement autoFillingOption;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement messageElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getAutoFillingOption(UserType type) {
        return autoFillingOption.format(UserService.getUser(type).getUsername());
    }

}
