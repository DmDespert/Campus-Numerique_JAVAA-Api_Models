package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import java.util.List;

/*
 ** ProductDao rassemble les methodes de Product, le controller interrogera Dao,
 *  Dao interrogera le Model.
 */

public interface ProductDao {
    public List<Product> findAll();

    public Product findById(int id);

    public Product save(Product product);

    public Product update(Product product, int id);

    public Boolean delete(int id);
}
