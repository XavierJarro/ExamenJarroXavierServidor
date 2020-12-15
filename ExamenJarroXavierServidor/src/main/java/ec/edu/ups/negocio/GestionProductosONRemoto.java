/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Starman
 */
@Remote
public interface GestionProductosONRemoto {

    public boolean guardarProducto(Producto producto);

    public boolean actualizarProducto(Producto producto);

    public Producto buscarProducto(int codigo) throws Exception;

    public List<Producto> listaProductos();

}
