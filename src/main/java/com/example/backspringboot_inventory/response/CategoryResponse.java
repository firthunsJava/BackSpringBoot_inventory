package com.example.backspringboot_inventory.response;

import com.example.backspringboot_inventory.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {

    private List<Category> category;

}

