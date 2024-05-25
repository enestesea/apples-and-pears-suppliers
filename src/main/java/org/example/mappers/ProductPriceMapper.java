package org.example.mappers;

import org.example.dtos.ProductPriceDTO;
import org.example.models.ProductPrice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-маппер для преобразования объектов ProductPrice в ProductPriceDTO и наоборот
 */
@Component
public class ProductPriceMapper {

    /**
     * Преобразовать объект ProductPrice в ProductPriceDTO
     *
     * @param productPrice объект ProductPrice
     * @return объект ProductPriceDTO
     */
    public static ProductPriceDTO toDTO(final ProductPrice productPrice) {
        if (productPrice == null) {
            return null;
        }

        final ProductPriceDTO dto = new ProductPriceDTO();
        dto.setId(productPrice.getId());
        dto.setSupplierId(productPrice.getSupplierId());
        dto.setProductId(productPrice.getProductId());
        dto.setPrice(productPrice.getPrice());
        dto.setStartDate(productPrice.getStartDate());
        dto.setEndDate(productPrice.getEndDate());
        return dto;
    }

    /**
     * Преобразовать объект ProductPriceDTO в ProductPrice
     *
     * @param productPriceDTO объект ProductPriceDTO
     * @return объект ProductPrice
     */
    public static ProductPrice toEntity(final ProductPriceDTO productPriceDTO) {
        if (productPriceDTO == null) {
            return null;
        }

        final ProductPrice productPrice = new ProductPrice();
        productPrice.setId(productPriceDTO.getId());
        productPrice.setStartDate(productPriceDTO.getStartDate());
        productPrice.setEndDate(productPriceDTO.getEndDate());
        productPrice.setPrice(productPriceDTO.getPrice());
        productPrice.setSupplierId(productPriceDTO.getSupplierId());
        productPrice.setProductId(productPriceDTO.getProductId());

        return productPrice;
    }

    /**
     * Преобразовать список объектов ProductPrice в список объектов ProductPriceDTO
     *
     * @param productPrices список объектов ProductPrice
     * @return список объектов ProductPriceDTO
     */
    public static List<ProductPriceDTO> toDTOs(final List<ProductPrice> productPrices) {
        return productPrices.stream()
                .map(ProductPriceMapper::toDTO)
                .collect(Collectors.toList());
    }
}
