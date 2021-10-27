package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ModelDao;
import com.ecommerce.microcommerce.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
public class ModelController {

    @Autowired //Indique à Spring de fabriquer une Instance
    private ModelDao modelDao;

    /**
     * Get all Models
     * GET METHOD
     * @return
     */
    @RequestMapping(value = "/Models", method = RequestMethod.GET)
    public List<Model> listModels() {
        return modelDao.findAll();
    }

    /**
     * Get Model by Id
     * GET METHOD
     * @param id
     * @return
     */
    @GetMapping(value = "/Models/{id}")
    public Model showModel(@PathVariable int id) {
        return modelDao.findById(id);
    }

    /**
     * Add Model
     * POST METHOD
     * @param model
     * @return
     */
    @PostMapping(value = "/Models")
    public Model addModel(@RequestBody Model model) {
        return modelDao.save(model);
    }

    /**
     * Edit Model
     * PUT METHOD
     * @param model
     * @param id
     * @return
     */
    @PutMapping(value = "/Models/{id}")
    public Model editModel(@RequestBody Model model, @PathVariable int id) {
        return modelDao.update(model, id);
    }

    /**
     * Delete Model
     * DELETE METHOD
     * @param id
     * @return
     */
    @DeleteMapping(value = "/Models/{id}")
    public Boolean deleteModel(@PathVariable int id) {
        return modelDao.delete(id);
    }
}
