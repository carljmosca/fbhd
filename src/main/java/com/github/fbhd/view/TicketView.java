/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.view;

import com.github.fbhd.Sections;
import com.github.fbhd.main.BaseView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

@SpringView(name = TicketView.VIEW_NAME)
@SideBarItem(sectionId = Sections.EXECUTION,
        caption = "Ticket",
        order = 20)
@FontAwesomeIcon(FontAwesome.TICKET)
public class TicketView extends BaseView {

    public static final String VIEW_NAME = "";
    private VerticalLayout mainLayout;
    private HorizontalLayout detailLayout;
    private HorizontalLayout buttonLayout;
    private TextField tfSummary;
    private TextField tfDetail;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public TicketView() {
    }

    @PostConstruct
    void init() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);

        createDetail();
        createButtons();

        addComponent(mainLayout);
        setSizeFull();
        setResponsive(true);

        //bind();
    }

    private void createDetail() {
        detailLayout = new HorizontalLayout();
        tfSummary = new TextField();
        tfSummary.setInputPrompt("Summary");
        detailLayout.addComponent(tfSummary);
        mainLayout.addComponent(detailLayout);
    }

    private void createButtons() {
        buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);

        Button btnSubmit = new Button("Submit");
        btnSubmit.setStyleName(ValoTheme.BUTTON_PRIMARY);

        btnSubmit.addClickListener((Button.ClickEvent event) -> {
            persistAndContinue(ConfirmationView.VIEW_NAME);
        });

        Button btnCancel = new Button("Cancel");

        btnCancel.addClickListener((Button.ClickEvent event) -> {

        });

        buttonLayout.addComponents(btnSubmit, btnCancel);
        mainLayout.addComponent(buttonLayout);
    }


}
