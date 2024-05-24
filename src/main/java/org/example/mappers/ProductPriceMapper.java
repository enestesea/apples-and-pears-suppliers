package org.example.mappers;

import org.example.dtos.ProductDTO;
import org.example.dtos.ProductPriceDTO;
import org.example.models.Product;
import org.example.models.ProductPrice;
import org.example.models.Type;
import org.example.repositories.SupplierRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductPriceMapper {

    public static ProductPriceDTO toDTO(ProductPrice productPrice) {
        if (productPrice == null) {
            return null;
        }

        ProductPriceDTO dto = new ProductPriceDTO();
        dto.setId(productPrice.getId());
        dto.setSupplierId(productPrice.getSupplierId());
        dto.setProductId(productPrice.getProductId());
        dto.setPrice(productPrice.getPrice());
        dto.setStartDate(productPrice.getStartDate());
        dto.setEndDate(productPrice.getEndDate());
        return dto;
    }

    public static ProductPrice toEntity(ProductPriceDTO productPriceDTO) {
        if (productPriceDTO == null) {
            return null;
        }

        ProductPrice productPrice = new ProductPrice();
        productPrice.setId(productPriceDTO.getId());
        productPrice.setStartDate(productPriceDTO.getStartDate());
        productPrice.setEndDate(productPriceDTO.getEndDate());
        productPrice.setPrice(productPriceDTO.getPrice());
        productPrice.setSupplierId(productPriceDTO.getSupplierId());
        productPrice.setProductId(productPriceDTO.getProductId());

        return productPrice;
    }
    public static List<ProductPriceDTO> toDTOs(List<ProductPrice> productPrices) {
        List<ProductPriceDTO> productPriceDTOs = productPrices.stream()
                .map(ProductPriceMapper::toDTO)
                .collect(Collectors.toList());
        return productPriceDTOs;

    }
}
