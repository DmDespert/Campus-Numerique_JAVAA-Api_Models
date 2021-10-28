package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Integer> { }