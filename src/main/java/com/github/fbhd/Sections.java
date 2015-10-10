/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@SideBarSections({

        @SideBarSection(id = Sections.EXECUTION, caption = "Execution")

})
@Component
public class Sections {


    public static final String EXECUTION = "execution";

}