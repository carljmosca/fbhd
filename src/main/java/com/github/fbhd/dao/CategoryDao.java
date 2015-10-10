/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fbhd.dao;

import com.github.fbhd.entity.Category;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author moscac
 */
@Transactional
public interface CategoryDao extends CrudRepository<Category, UUID> {
    
    
}
