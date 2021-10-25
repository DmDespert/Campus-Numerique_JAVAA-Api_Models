package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Indique à Spring qu'il s'agit d'une classe qui gère des données
public class ProductDaoImpl implements ProductDao {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("Aspirateur"), 350));
        products.add(new Product(2, new String("Ordinateur"), 1050));
        products.add(new Product(3, new String("Téléphone"), 250));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
