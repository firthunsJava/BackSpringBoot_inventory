package com.example.backspringboot_inventory.dao;

import com.example.backspringboot_inventory.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDao extends CrudRepository<Product, Long> {

/** CrudRepository-> tiene los metodos que se necesita para realizar un Cruc, PERO SI queremos algo especifico como
 * buscar por un termino, en vez del ID  que nos porporciona la interfaz tenemos que crearnos nuestro propia interfaz
 * personalizada...
 *
 * En el siguiente enlace tenemos el manual para poder crear metodos a traves de  queries
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 *
 * */
    // METODO 1- para poder realizar busquedas por nombre
    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByNameLike(String name);

// METODO 2 -> findByNameContainingIgnoreCase https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    List<Product> findByNameContainingIgnoreCase(String name);
}
