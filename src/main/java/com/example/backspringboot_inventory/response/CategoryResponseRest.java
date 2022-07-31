package com.example.backspringboot_inventory.response;


import lombok.*;


@Getter
@Setter
public class CategoryResponseRest extends ResponseRest{
/** **   Info que se le mostrará al usuario. */
    private CategoryResponse categoryResponse = new CategoryResponse();
}
