package org.example.controllers;

import org.example.dtos.ProductDTO;
import org.example.mappers.ProductMapper;
import org.example.models.Product;
import org.example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        final List<Product> products = productService.getAllProducts();
        final List<ProductDTO> productDTOs = ProductMapper.toDTOs(products);
        return ResponseEntity.ok(productDTOs);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        final Product product = ProductMapper.toEntity(productDTO);
        final Product savedProduct = productService.addProduct(product);
        final ProductDTO savedProductDTO = ProductMapper.toDTO(savedProduct);
        return ResponseEntity.ok(savedProductDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        final Product product = productService.getProductById(id);
        final ProductDTO productDTO = ProductMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);
    }


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
