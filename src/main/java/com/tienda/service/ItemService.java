/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joses
 */
public interface ItemService {

    public List<Item> listaItems = new ArrayList<>();

    public List<Item> getItems();

    public void save(Item item);

    public void delete(Item item);
    
    public Item getItem(Item item);

    public void actualiza(Item item);

    public void facturar();
}
