package org.example.controllers;

import org.example.dtos.ProductPriceDTO;
import org.example.mappers.ProductPriceMapper;
import org.example.models.ProductPrice;
import org.example.services.ProductPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-prices")
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @GetMapping
    public ResponseEntity<List<ProductPriceDTO>> getAllProductPrices() {
        final List<ProductPrice> productPrices = productPriceService.getAllProductPrices();
        final List<ProductPriceDTO> productPriceDTOs = ProductPriceMapper.toDTOs(productPrices);
        return ResponseEntity.ok(productPriceDTOs);
    }

    @PostMapping
    public ResponseEntity<ProductPriceDTO> createProductPrice(@RequestBody ProductPriceDTO productPriceDTO) {
        final ProductPrice productPrice = ProductPriceMapper.toEntity(productPriceDTO);
        final ProductPrice savedProductPrice = productPriceService.addProductPrice(productPrice);
        final ProductPriceDTO savedProductPriceDTO = ProductPriceMapper.toDTO(savedProductPrice);
        return ResponseEntity.ok(savedProductPriceDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPriceDTO> getProductPriceById(@PathVariable Long id) {
        final ProductPrice productPrice = productPriceService.getProductPriceById(id);
        final ProductPriceDTO productPriceDTO = ProductPriceMapper.toDTO(productPrice);
        return ResponseEntity.ok(productPriceDTO);
    }


    @PatchMapping("/{id}")
    public ProductPrice updateProductPrice(@PathVariable Long id, @RequestBody ProductPrice productPrice) {
        return productPriceService.updateProductPrice(id, productPrice);
    }

    @DeleteMapping("/{id}")
    public void deleteProductPrice(@PathVariable Long id) {
        productPriceService.deleteProductPrice(id);
    }
}
