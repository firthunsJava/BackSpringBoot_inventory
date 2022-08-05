package com.example.backspringboot_inventory.response;

import com.example.backspringboot_inventory.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {

    List<Product> products;
}
