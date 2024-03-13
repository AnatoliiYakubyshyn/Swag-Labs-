package com.solvd.carina.demo.mobile.gui.factories;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.AboutWebPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PageFactory extends AbstractTest implements IDriverPool {
    public AbstractPage getPage(PageOption pageOption) {
        switch (pageOption) {
            case WEB_VIEW:
                return initPage(WebViewPageBase.class);
            case ABOUT:
                return initPage(AboutWebPageBase.class);
            case DRAWING:
                return initPage(DrawPageBase.class);
            default:
                return initPage(ProductsPageBase.class);
        }
    }
}
