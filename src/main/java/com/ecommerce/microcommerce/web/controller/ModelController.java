package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.model.Model;
import com.ecommerce.microcommerce.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@RestController
@EnableSwagger2
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    /**
     * Get all Models
     * GET METHOD
     * @return
     */
    @RequestMapping(value = "/Models", method = RequestMethod.GET)
    public Iterable<Model> listModels() {
        return modelRepository.findAll();
    }

    /**
     * Get Model by Id
     * GET METHOD
     * @param id
     * @return
     */
    @GetMapping(value = "/Models/{id}")
    public Model showModel(@PathVariable int id) {
        return modelRepository.findById(id).get();
    }

    /**
     * Add Model
     * POST METHOD
     * @param model
     * @return
     */
    @PostMapping(value = "/Models")
    public Model addModel(@RequestBody Model model) {
        return modelRepository.save(model);
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
        return modelRepository.findById(id).map(isModel-> {
            isModel.setModel(model.getModel());
            return modelRepository.save(isModel);
        }).orElseGet(()-> {
            model.setId(id);
            return modelRepository.save(model);
        });
    }

    /**
     * Delete Model
     * DELETE METHOD
     * @param id
     * @return
     */
    @DeleteMapping(value = "/Models/{id}")
    public Boolean deleteModel(@PathVariable int id) {
        if(modelRepository.existsById(id)) {
            modelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
