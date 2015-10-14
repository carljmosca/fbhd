/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd;

import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;

/**
 *
 * @author moscac
 */
@SpringComponent
public class FbhdViewAccessControl implements ViewAccessControl {

    @Override
    public boolean isAccessGranted(UI ui, String viewName) {
        if ("mainView".equals(viewName))
            return true;
        return ValoSideBarUI.get().isLoggedIn();
    }
    
}
