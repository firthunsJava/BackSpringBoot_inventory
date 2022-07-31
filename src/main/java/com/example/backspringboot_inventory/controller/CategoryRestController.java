package com.example.backspringboot_inventory.controller;

import com.example.backspringboot_inventory.model.Category;
import com.example.backspringboot_inventory.response.CategoryResponseRest;
import com.example.backspringboot_inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"}) // cors, que mi servidor me permite la transmisión de datos
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service; // instancio a mi servicio

    /**
     * get all the categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    /**
     * get categories by id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id) {

        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }


    /**
     * save categories
     * @param Category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {

        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
    }

    /**
     * update categories
     * @param category
     * @param id
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id) {

        ResponseEntity<CategoryResponseRest> response = service.update(category, id);
        return response;
    }

    /**
     * delete categorie
     * @param id
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id) {

        ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
        return response;
    }

//    /**
//     * export to excel file
//     * @param respons
//     * @throws IOException
//     */
//    @GetMapping("/categories/export/excel")
//    public void exportToExcel(HttpServletResponse response) throws IOException {
//
//        response.setContentType("application/octet-stream");
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=result_category";
//        response.setHeader(headerKey, headerValue);
//
//        ResponseEntity<CategoryResponseRest> categoryResponse = service.search();
//
//        CategoryExcelExporter excelExporter = new CategoryExcelExporter(
//                categoryResponse.getBody().getCategoryResponse().getCategory());
//
//        excelExporter.export(response);
//
//
//    }

}
