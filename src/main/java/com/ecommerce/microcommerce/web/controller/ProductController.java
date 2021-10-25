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
    @RequestMapping(value = "/Products", method = RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    //Request raccourcie
    @GetMapping(value = "/Products/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //Request Post raccourcie
    @PostMapping(value = "/Products/{id}")
    public String ajouteUnProduit(@PathVariable int id) {
        return "Ajout du produit numéro " + id;
    }

    //Request Put raccourcie
    @PutMapping(value = "/Products/{id}")
    public String modifieUnProduit(@PathVariable int id) {
        return "Modification du produit numéro " + id;
    }

    //Request delete raccourcie
    @DeleteMapping(value = "/Products/{id}")
    public String deleteUnProduit(@PathVariable int id) {
        return "Suppression du produit numéro " + id;
    }
}
