/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.domain.Articulo;
import com.tienda.domain.Item;
import com.tienda.service.ArticuloService;
import com.tienda.service.CategoriaService;
import com.tienda.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joses
 */
@Controller
@Slf4j
public class CarritoController1 {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ArticuloService articuloService;

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String Inicio(Model model) {
        var items = itemService.getItems();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }

        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    //Para agregar un articulo al carrito
    @GetMapping("/carrito/agregar/{idArticulo}")
    public ModelAndView agregarArticulo(Model model, Item item) {
        Item item2 = itemService.getItem(item);
        if (item2 == null) {
            Articulo articulo = articuloService.getArticulo(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.getItems();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    //Para modificar un articulo del carrito
    @GetMapping("/carrito/modificar/{idArticulo}")
    public String modificarItem(Item item, Model model) {
        item = itemService.getItem(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{idArticulo}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un articulo del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    //Para facturar los articulos del carrito
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
