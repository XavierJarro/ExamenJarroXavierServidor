/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Starman
 */
@Stateless
public class GestionProductosON implements GestionProductosONRemoto {

    @Inject
    private ProductoDao daoProducto;

    public boolean guardarProducto(Producto producto) {
        daoProducto.insertJPA(producto);
        return true;
    }

    public boolean actualizarProducto(Producto producto) {
        daoProducto.updateJPA(producto);
        return true;
    }

    public Producto buscarProducto(int codigo) throws Exception {
        Producto producto = daoProducto.readJPA(codigo);
        if (producto == null) {
            throw new Exception("producto no existe");
        }
        return producto;
    }

    public List<Producto> listaProductos() {
        return (List<Producto>) daoProducto.listaProductos();
    }

}
