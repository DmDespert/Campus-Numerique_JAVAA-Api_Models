package com.ecommerce.microcommerce.web.controller;
import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired //Indique à Spring de fabriquer une Instance
    private ProductDao productDao;

    //Request avec methode spécifiée
    @RequestMapping(value="/Produits", method= RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    //Request raccourcie
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //Request Post raccourcie
    @PostMapping(value="/Produits/{id}")
    public String ajouteUnProduit(@PathVariable int id) {
        return "Ajout du produit numéro " + id;
    }

    //Request Put raccourcie
    @PutMapping(value="/Produits/{id}")
    public String modifieUnProduit(@PathVariable int id) {
        return "Modification du produit numéro " + id;
    }

    //Request delete raccourcie
    @DeleteMapping(value="/Produits/{id}")
    public String deleteUnProduit(@PathVariable int id) {
        return "Suppression du produit numéro " + id;
    }
}
