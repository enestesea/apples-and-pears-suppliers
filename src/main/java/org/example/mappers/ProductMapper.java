package org.example.mappers;

import org.example.dtos.ProductDTO;
import org.example.models.Product;
import org.example.models.Type;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-маппер для преобразования объектов Product в ProductDTO и наоборот
 */
public class ProductMapper {

    /**
     * Преобразовать объект Product в ProductDTO
     *
     * @param product объект Product
     * @return объект ProductDTO
     */
    public static ProductDTO toDTO(final Product product) {
        if (product == null) {
            return null;
        }

        final ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setType(product.getType().name()); // Предполагается, что Type является перечислением

        return productDTO;
    }

    /**
     * Преобразовать объект ProductDTO в Product
     *
     * @param productDTO объект ProductDTO
     * @return объект Product
     */
    public static Product toEntity(final ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        final Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setType(Type.valueOf(productDTO.getType())); // Предполагается, что Type является перечислением

        return product;
    }

    /**
     * Преобразовать список объектов Product в список объектов ProductDTO
     *
     * @param products список объектов Product
     * @return список объектов ProductDTO
     */
    public static List<ProductDTO> toDTOs(final List<Product> products) {
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
