package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.apache.commons.lang3.NotImplementedException;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ICommonContent;

public interface IIOSCommonContentPages extends ICommonContent {
    @Override
    default HeaderMenuBase getHeaderMenu() {
       throw new NotImplementedException();
    }
}
