/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joses
 */
public interface CreditoDao extends CrudRepository<Credito, Long>{
    
}
