package com.github.fbhd;

import com.github.fbhd.dao.TicketDao;
import com.github.fbhd.entity.Ticket;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import javax.servlet.http.HttpSession;
import org.vaadin.spring.sidebar.components.AbstractSideBar;
import org.vaadin.spring.sidebar.components.ValoSideBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.annotation.EnableI18N;

@SpringUI
@Theme("sidebar") // A custom theme based on Valo
@EnableI18N
public class ValoSideBarUI extends AbstractSideBarUI {

    @Autowired
    ValoSideBar sideBar;
    @Autowired
    TicketDao ticketDao;
    @Autowired
    private HttpSession httpSession;
    
    public static final String ERROR_ATTRIBUTE = "ERROR";
    public static final String EMAIL_ATTRIBUTE = "EMAIL";
    protected boolean redactionNoticedAcknowledged;
    protected Ticket ticket;
    private boolean loggedIn;
    private String email;
    private String error;

    public ValoSideBarUI() {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        super.init(vaadinRequest);

        CssLayout header = new CssLayout();
        
        error = (String)httpSession.getAttribute(ERROR_ATTRIBUTE);
        email = (String)httpSession.getAttribute(EMAIL_ATTRIBUTE);
        loggedIn = email != null && !email.isEmpty();

        vaadinRequest.getWrappedSession().getAttribute(DESIGN_ATTR_PLAIN_TEXT);

        MenuBar menuBar = new MenuBar();
        header.addComponent(menuBar);

        MenuBar.MenuItem settingsItem = menuBar.addItem("", FontAwesome.WRENCH, null);

        MenuBar.MenuItem useLargeIconsItem = settingsItem.addItem("Use large icons", (MenuBar.MenuItem selectedItem) -> {
            sideBar.setLargeIcons(selectedItem.isChecked());
        });
        useLargeIconsItem.setCheckable(true);

        MenuBar.MenuItem showLogoItem = settingsItem.addItem("Show logo", (MenuBar.MenuItem selectedItem) -> {
            if (selectedItem.isChecked()) {
                showLogo();
            } else {
                hideLogo();
            }
        });
        showLogoItem.setCheckable(true);
        sideBar.setHeader(header);
        ticket = new Ticket();
    }

    private void showLogo() {
        sideBar.setLogo(new Label(FontAwesome.ROCKET.getHtml(), com.vaadin.shared.ui.label.ContentMode.HTML));
    }

    private void hideLogo() {
        sideBar.setLogo(null);
    }

    @Override
    protected AbstractSideBar getSideBar() {
        return sideBar;
    }

    public static ValoSideBarUI get() {
        return (ValoSideBarUI) UI.getCurrent();
    }

    public com.github.fbhd.dto.Ticket getTicket() {
        com.github.fbhd.dto.Ticket ticketDto = new com.github.fbhd.dto.Ticket();
        return ticketDto;
    }

    public void persistTicket() {
        ticketDao.save(ticket);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getEmail() {
        return email;
    }

    public String getError() {
        return error;
    }

}
