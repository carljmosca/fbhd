/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.view;

import com.github.fbhd.Sections;
import com.github.fbhd.main.BaseView;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 *
 * @author moscac
 */
@SpringView(name = ConfirmationView.VIEW_NAME)
@SideBarItem(sectionId = Sections.EXECUTION,
        caption = "Confirmation",
        order = 30)
@FontAwesomeIcon(FontAwesome.SEND)
public class ConfirmationView extends BaseView {
    public static final String VIEW_NAME = "confirmation";
}
