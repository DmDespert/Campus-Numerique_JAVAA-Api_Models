package com.ecommerce.microcommerce.model;

import java.util.Objects;

public class Model {
    private int id;
    private String model;

    public Model() {}

    public Model(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Model{"+
                "id=" + id +
                ", model=" + model + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model1 = (Model) o;
        return id == model1.id && Objects.equals(model, model1.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }
}
