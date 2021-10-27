package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Model;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ModelDaoImpl implements ModelDao {
    public static List<Model> models = new ArrayList<>();
    static {
        models.add(new Model(1, new String("Scenic MPV")));
        models.add(new Model(2, new String("Polo 6")));
        models.add(new Model(3, new String("AMG C 63 S")));
    }

    /**
     * Find all method return list of models
     * @return
     */
    @Override
    public List<Model> findAll() {
        return models;
    }

    /**
     * Find one Model method, return Model by id
     * @param id
     * @return
     */
    @Override
    public Model findById(int id) {
        for (Model tableModel : models) {
            if (tableModel.getId() == id) {
                return tableModel;
            }
        }
        return null;
    }

    /**
     * Save Model method, return Model to add
     * @param model
     * @return
     */
    @Override
    public Model save(Model model) {
        boolean trueOrFalse = false;
        for (Model tableModel : models) {
            if (tableModel.getId() == model.getId()) {
                trueOrFalse = true;
                break;
            }
        }
        if(!trueOrFalse) {
            models.add(model);
            return model;
        }
        return null;
    }

    /**
     * Update Model method, return edited Model
     * @param model
     * @param id
     * @return
     */
    @Override
    public Model update(Model model, int id) {
        for (Model tableModel : models) {
            if (tableModel.getId() == id) {
                tableModel.setModel(model.getModel());
                return tableModel;
            }
        }
        return null;
    }

    /**
     * Delete Model method, return true or false success
     * @param id
     * @return
     */
    @Override
    public Boolean delete(int id) {
        for (Model tableModel : models) {
            if (tableModel.getId() == id) {
                models.remove(tableModel);
                return true;
            }
        }
        return false;
    }

}
