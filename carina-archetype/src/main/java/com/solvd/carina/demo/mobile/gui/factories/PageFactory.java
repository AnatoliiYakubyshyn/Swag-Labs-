package com.solvd.carina.demo.mobile.gui.factories;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.gui.pages.common.ICommonContent;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;

public class PageFactory extends AbstractTest implements IDriverPool {
    public ICommonContent getPage(PageOption pageOption) {
        switch (pageOption) {
            case WEB_VIEW:
                return initPage(WebViewPageBase.class);
            default:
                return initPage(ProductsPageBase.class);
        }
    }
}
