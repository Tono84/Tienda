/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import lombok.Data;

/**
 *
 * @author joses
 */
@Data
public class Item extends Articulo{
    private int cantidad; //Almacena la cantidad de items de un articulo
    
    public Item(){
        
    }
    
    public Item(Articulo articulo) {
        super.setIdArticulo(articulo.getIdArticulo());
        super.setIdCategoria(articulo.getIdCategoria());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setRutaImagen(articulo.getRutaImagen());
        this.cantidad=0;
    }
}
