package org.example.mappers;

import org.example.dtos.ProductDTO;
import org.example.models.Product;
import org.example.models.Type;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setType(product.getType().name()); // Assuming Type is an enum

        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setType(Type.valueOf(productDTO.getType())); // Assuming Type is an enum

        return product;
    }

    public static List<ProductDTO> toDTOs(List<Product> products) {
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        return productDTOs;

    }
}
