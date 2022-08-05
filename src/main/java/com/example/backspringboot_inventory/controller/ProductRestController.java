package com.example.backspringboot_inventory.controller;


import com.example.backspringboot_inventory.model.Product;
import com.example.backspringboot_inventory.response.ProductResponseRest;
import com.example.backspringboot_inventory.services.IProductService;
import com.example.backspringboot_inventory.util.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    private IProductService productService;


    public ProductRestController(IProductService productService) {
        super();
        this.productService = productService;
    }
    /**
     *
     * @param picture
     * @param name
     * @param price
     * @param account
     * @param categoryID
     * @return
     * @throws IOException
     */
    @PostMapping("/products")
    public ResponseEntity<ProductResponseRest> save(
            @RequestParam("picture") MultipartFile picture,
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("account") int account,
            @RequestParam("categoryId") Long categoryID
            ) throws IOException
            {

                Product product = new Product();
                product.setName(name);
                product.setAccount(account);
                product.setPrice(price);
                product.setPicture(Util.compressZLib(picture.getBytes()));

                ResponseEntity<ProductResponseRest> response = productService.save(product, categoryID);

                return response;
            }

    /**
     * search by id
     * @param id
     * @return
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id){
        ResponseEntity<ProductResponseRest> response = productService.searchById(id);
        return response;
    }


    /**
     * search by name
     * @param name
     * @return
     */
    @GetMapping("/products/filter/{name}")
    public ResponseEntity<ProductResponseRest> searchByName(@PathVariable String name){
        ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
        return response;
    }

    /**
     * delete by id
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> deleteById(@PathVariable Long id){
        ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
        return response;
    }

    /**
     * get products
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<ProductResponseRest> search(){
        ResponseEntity<ProductResponseRest> response = productService.search();
        return response;
    }


    /**
     * update product
     * @param picture
     * @param name
     * @param price
     * @param account
     * @param categoryID
     * @param id
     * @return
     * @throws IOException
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> update(
            @RequestParam("picture") MultipartFile picture,
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("account") int account,
            @RequestParam("categoryId") Long categoryID,
            @PathVariable Long id) throws IOException
    {

        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));

        ResponseEntity<ProductResponseRest> response = productService.update(product, categoryID, id);

        return response;


    }

    /**
     * export product in excel file
     * @param response
     * @throws IOException
     */
    @GetMapping("/products/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_product";
        response.setHeader(headerKey, headerValue);

        ResponseEntity<ProductResponseRest> products = productService.search();

//        ProductExcelExporter excelExporter = new ProductExcelExporter(
//                products.getBody().getProduct().getProducts());
//
//        excelExporter.export(response);


    }



}

