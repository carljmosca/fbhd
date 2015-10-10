/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.main;

import com.github.fbhd.ValoSideBarUI;
import com.github.fbhd.dto.Ticket;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

public class BasePanel extends Panel {

    protected Ticket ticket;
    protected BeanFieldGroup<Ticket> fieldGroup;

    protected void bind() {
        ticket = ((ValoSideBarUI)UI.getCurrent()).getTicket();
        fieldGroup = new BeanFieldGroup<>(Ticket.class);
        fieldGroup.setItemDataSource(ticket);
        fieldGroup.setBuffered(false);
        fieldGroup.bindMemberFields(this);
    }

    public BeanFieldGroup<Ticket> getFieldGroup() {
        return fieldGroup;
    }
}
