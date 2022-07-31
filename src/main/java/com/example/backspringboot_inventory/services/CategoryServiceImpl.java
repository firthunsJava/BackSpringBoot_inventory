package com.example.backspringboot_inventory.services;

import com.example.backspringboot_inventory.dao.ICategoryDao;
import com.example.backspringboot_inventory.model.Category;
import com.example.backspringboot_inventory.response.CategoryResponseRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceImpl implements  ICategoryService{

    /** LA ANOTACIÓN AUTOWIRED, de spring me sirve para inyectar el objeto a mi contenedor de Spring,
     * para que  esté listo  para usarse */
    @Autowired
    private ICategoryDao categoryDao;


    @Override
    @Transactional(readOnly = true) //DECORAR CON LA ANOTACIÓN
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest response = new CategoryResponseRest();

        try {

            List<Category> category = (List<Category>) categoryDao.findAll();

            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");


        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);


        }

        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryResponseRest> deleteById(Long id) {
        return null;
    }
}
