package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Model;

import java.util.List;

public interface ModelDao {
    public List<Model> findAll();

    public Model findById(int id);

    public Model save(Model model);

    public Model update(Model model, int id);

    public Boolean delete(int id);
}
