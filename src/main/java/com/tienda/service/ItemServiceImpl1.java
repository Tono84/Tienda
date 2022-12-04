package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import com.tienda.domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joses
 */
@Service
public class ItemServiceImpl1 implements ItemService {

    @Override
    public List<Item> getItems() {
        return listaItems;
    }
    
    //Se usa en el addCarrito agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item c : listaItems) {
            //busca si ya existe el articulo en el carrito
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                //Valida si aun puede colocar un item adicional segun existencias
                if (c.getCantidad() < item.getExistencias()) {
                    //Incrementa en 1 la cantidad de elementos
                    c.setCantidad(c.getCantidad() + 1);
                }

                existe = true;
                break;
            }
        }
        if (!existe) { // Si no esta el articulo en el carrito entonces lo agrega cantidad =1
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    //Se usa para eliminar un articulo del carrito
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item c : listaItems) {
            ++posicion;
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                existe = true;
            }
            break;
        }

        if (existe) {
            listaItems.remove(posicion);
        }
    }

    //se obtiene la informacion de un articulo del carrito para modificarlo
    @Override
    public Item getItem(Item item) {
        for(Item c : listaItems) {
            if(Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                return c;
            }
        }
        return null;
    }

        //se una en la pagina para actualizar la cantidad de articulos
    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if(Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }
    
    //Proceso para generar la facturacion 
    @Override
    public void facturar() {
        for (Item i : listaItems) {
            //Proceso de facturacion
        }
        
        listaItems.clear();
    }

}
