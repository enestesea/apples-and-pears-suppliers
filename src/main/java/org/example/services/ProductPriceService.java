package org.example.services;

import org.example.models.ProductPrice;
import org.example.repositories.ProductPriceRepository;
import org.example.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    public final List<ProductPrice> getAllProductPrices() {
        return productPriceRepository.findAll();
    }

    public final ProductPrice getProductPriceById(Long id) {
        return productPriceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductPrice not found with id: " + id));
    }

    public final ProductPrice addProductPrice(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    public final ProductPrice updateProductPrice(Long id, ProductPrice productPrice) {
        final ProductPrice existingProductPrice = getProductPriceById(id);
        existingProductPrice.setEndDate(productPrice.getEndDate());
        existingProductPrice.setStartDate(productPrice.getStartDate());
        existingProductPrice.setProductId(productPrice.getProductId());
        existingProductPrice.setSupplierId(productPrice.getSupplierId());
        existingProductPrice.setPrice(productPrice.getPrice());
        return productPriceRepository.save(existingProductPrice);
    }

    public final void deleteProductPrice(Long id) {
        productPriceRepository.deleteById(id);
    }
}