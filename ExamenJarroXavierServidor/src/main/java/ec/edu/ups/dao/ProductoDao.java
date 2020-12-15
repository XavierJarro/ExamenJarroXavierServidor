/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Starman
 */
@Stateless
public class ProductoDao {

    @Inject
    private EntityManager em;

    public boolean insertJPA(Producto entity) {
        em.persist(entity);
        return true;
    }

    public boolean updateJPA(Producto entity) {
        em.merge(entity);
        return true;
    }

    public Producto readJPA(int codigo) {
        Producto p = em.find(Producto.class, codigo);
        return p;
    }

    public List<Producto> listaProductos() {
        String jpql = "SELECT p FROM producto p";

        Query q = em.createQuery(jpql, Producto.class);

        List<Producto> listado = q.getResultList();

        return listado;
    }
}
