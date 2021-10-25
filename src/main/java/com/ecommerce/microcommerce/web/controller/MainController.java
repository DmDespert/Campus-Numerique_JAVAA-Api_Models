package com.ecommerce.microcommerce.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import com.ecommerce.microcommerce.form.ProductForm;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Value("${welcome.message}")
    private String message;

    @Autowired
    private ProductDaoImpl products;

    @GetMapping(value="/")
    public String index(Model model) {

        model.addAttribute("message", message);
        model.addAttribute("products", products.findAll());

        return "index";
    }

    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.GET)
    public String showAddProductPage(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);

        return "addProduct";

    }

    @RequestMapping(value={"/addProduct"}, method = RequestMethod.POST)
    public String saveProduct(Model model, @ModelAttribute("ProductForm") ProductForm productForm) {
        int id = productForm.getId();
        String marque = productForm.getMarque();
        String modele = productForm.getModel();
        String color = productForm.getColor();

        if(marque != null && marque.length() > 0
                && model != null && modele.length() > 0
                && color != null && color.length() > 0)
        {
            Product newProduct = new Product(id, marque, modele, color);
            products.save(newProduct);

            return "redirect:/";

        }

        return "addProduct";
    }

}
