/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.main;

import com.github.fbhd.ValoSideBarUI;
import com.github.fbhd.dto.Ticket;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

/**
 *
 * @author moscac
 */
public class BaseView extends CssLayout implements View { //, ViewAccessControl {

    protected Ticket ticket;
    protected BeanFieldGroup<Ticket> fieldGroup;

    protected void bind() {
        ticket = ((ValoSideBarUI) UI.getCurrent()).getTicket();
        fieldGroup = new BeanFieldGroup<>(Ticket.class);
        fieldGroup.setItemDataSource(ticket);
        fieldGroup.setBuffered(false);
        fieldGroup.bindMemberFields(this);
    }

    protected void persistAndContinue(String nextView) {
        ((ValoSideBarUI) UI.getCurrent()).persistTicket();
        UI.getCurrent().getNavigator().navigateTo(nextView);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public BeanFieldGroup<Ticket> getFieldGroup() {
        return fieldGroup;
    }

//    @Override
//    public boolean isAccessGranted(UI ui, String string) {
//        return true;
//    }

}
