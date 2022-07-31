package com.example.backspringboot_inventory.dao;

import com.example.backspringboot_inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {

}