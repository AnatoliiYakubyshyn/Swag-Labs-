package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.services.UserService;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class LoginPageBase extends AbstractPage implements IMobileUtils {

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getLoginBtn());
    }

    protected abstract ExtendedWebElement getUserNameField();

    protected abstract ExtendedWebElement getPasswordField();

    protected abstract ExtendedWebElement getLoginBtn();

    protected abstract ExtendedWebElement getAutoFillingOption(UserType type);

    protected abstract ExtendedWebElement getMessageElement();

    public ProductListPageBase login(UserType userType, boolean useAutoFilling) {
        if (!useAutoFilling) {
            getUserNameField().type(UserService.getUser(userType).getUsername());
            getPasswordField().type(UserService.getUser(userType).getPassword());
        } else {
            swipeUp(3, 1000);
            getAutoFillingOption(userType).click();
            swipeDown(3, 1000);
            pause(1);
        }
        getLoginBtn().click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    public boolean isMessageDisplayed(String text) {
        return getMessageElement().format(text).isPresent();
    }
}
