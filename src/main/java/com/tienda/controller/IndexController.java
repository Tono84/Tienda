/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author joses
 */

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        Cliente cliente = new Cliente("Jose","Solorzano Flores","jsolorzano90547@ufide.ac.cr","88885555");
       //Cliente cliente2 = new Cliente("Alex","Lopez Galindo","aGalindo05454@ufide.ac.cr","54542222");
        
        //var clientes = Arrays.asList(cliente, cliente2);
        
        var clientes = clienteDao.findAll();
        
        model.addAttribute("clientes",clientes);
        model.addAttribute("cliente", cliente);

        return "index";
    }
    
}
