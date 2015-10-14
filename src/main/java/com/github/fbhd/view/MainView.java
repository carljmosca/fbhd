/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.view;

import com.github.fbhd.Sections;
import com.github.fbhd.ValoSideBarUI;
import com.github.fbhd.main.BaseView;
import com.github.fbhd.oauth.util.OAuthProvider;
import com.github.fbhd.oauth.util.OAuthUtil;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 *
 * @author moscac
 */
@SpringView(name = MainView.VIEW_NAME)
@SideBarItem(sectionId = Sections.EXECUTION,
        caption = "",
        order = 20)
@FontAwesomeIcon(FontAwesome.SIGN_IN)
public class MainView extends BaseView {

    public static final String VIEW_NAME = "";
    private VerticalLayout mainLayout;
    private HorizontalLayout detailLayout;
    private HorizontalLayout buttonLayout;
    @Autowired
    OAuthUtil oAuthUtil;
    @Autowired
    private HttpSession httpSession;

    @PostConstruct
    void init() {

//        UI ui = ValoSideBarUI.getCurrent();
//        if (ui != null) {
//            VaadinSession session = ui.getSession();
//            if (session != null) {
//                error = session.getAttribute(MainView.ERROR_ATTRIBUTE);
//                email = session.getAttribute(MainView.EMAIL_ATTRIBUTE);
//            }
//        }

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

        mainLayout.addComponent(detailLayout);
    }

    private void createButtons() {
        buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);

        Button btnLogin = new Button("Login");
        btnLogin.setStyleName(ValoTheme.BUTTON_PRIMARY);

        btnLogin.addClickListener((Button.ClickEvent event) -> {
            doLogin();
        });

        Button btnCancel = new Button("Cancel");

        btnCancel.addClickListener((Button.ClickEvent event) -> {

        });

        buttonLayout.addComponents(btnLogin, btnCancel);
        mainLayout.addComponent(buttonLayout);
    }

    private void doLogin() {

        OAuthProvider provider = oAuthUtil.getByName("GOOGLE");
        String url = provider.getOAuth().getAuthorizationUrl(provider.getScopes(),
                String.valueOf(System.currentTimeMillis()));
        getUI().getPage().setLocation(url);
    }
}
