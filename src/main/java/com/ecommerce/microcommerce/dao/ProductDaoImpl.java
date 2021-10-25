package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 ** Repository : Indique à Spring qu'il s'agit d'une classe qui gère des données
 *  La classe ProductDaoImpl génère des données en dur pour les tests (absence de BDD)
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("Renaud"), new String("Scenic MPV"), new String("Rouge")));
        products.add(new Product(2, new String("Volkswagen"), new String("Polo 6"), new String("Bleu")));
        products.add(new Product(3, new String("Mercedes"), new String("AMG C 63 S"), new String("Vert")));
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
