package rw.ac.rca.spring_boot_template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.models.Product;
import rw.ac.rca.spring_boot_template.services.serviceImpl.ProductServiceImpl;
import rw.ac.rca.spring_boot_template.utils.ApiResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping("/all")
    public ResponseEntity getAllProducts() {
        List<Product> products = productService.getProducts();

        return ResponseEntity.ok().body(
                new ApiResponse(
                        true,
                        "Successfully fetched the products",
                        products
                )
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getProduct(@PathVariable UUID id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully fetched the product",
                product
        ));


    }

    @PostMapping("/create")
    public ResponseEntity saveProduct(
            @RequestBody CreateProductDTO createProductDTO
    ) {
        Product product = productService.saveProduct(createProductDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully created the product",
                product
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable UUID id) {
        Product product = productService.deleteProduct(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully deleted the product",
                product
        ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable UUID id, CreateProductDTO createProductDTO) {
        Product product = productService.updateProduct(id, createProductDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully updated the product",
                product
        ));
    }

}
