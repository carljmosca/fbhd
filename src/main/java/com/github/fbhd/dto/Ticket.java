/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.dto;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

/**
 *
 * @author moscac
 */

@Data
public class Ticket implements Serializable {
    
    private UUID id;
    private String summary;
    private String description;
        
}
