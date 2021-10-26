package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 ** RestController informe Spring qu'on retournera du JSON
 *  grace à la dependance Jackson.
 */
@RestController
public class ProductController {

    @Autowired //Indique à Spring de fabriquer une Instance
    private ProductDao productDao;

    //Request avec méthode spécifiée
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    //Request raccourcie
    @GetMapping(value = "/products/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //Request Post raccourcie
    @PostMapping(value = "/products")
    public Product ajouteUnProduit(@RequestBody Product product) {
        return productDao.save(product);
    }

    //Request Put raccourcie
    @PutMapping(value = "/products/{id}")
    public Product modifieUnProduit(@RequestBody Product product, @PathVariable int id) {
        return productDao.update(product, id);
    }

    //Request delete raccourcie
    @DeleteMapping(value = "/products/{id}")
    public Boolean deleteUnProduit(@PathVariable int id) {
        return productDao.delete(id);
    }
}
