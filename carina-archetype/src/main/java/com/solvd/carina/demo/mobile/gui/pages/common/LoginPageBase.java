package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.services.UserService;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getUserNameField();

    protected abstract ExtendedWebElement getPasswordField();

    protected abstract ExtendedWebElement getLoginBtn();

    protected abstract ExtendedWebElement getAutoFillingOption(UserType type);

    public ProductsPageBase login(UserType userType, boolean useAutoFilling) {
        if (!useAutoFilling) {
            getUserNameField().type(UserService.getUser(userType).getUsername());
            getPasswordField().type(UserService.getUser(userType).getPassword());
        } else {
            getAutoFillingOption(userType).click();
        }
        getLoginBtn().click();
        return initPage(ProductsPageBase.class);
    }
}
