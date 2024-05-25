package org.example.controllers;

import org.example.dtos.ProductPriceDTO;
import org.example.mappers.ProductPriceMapper;
import org.example.models.ProductPrice;
import org.example.services.ProductPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления ценами продуктов. Цены заранее предоставлены поставщиками на определенные периоды
 */
@RestController
@RequestMapping("/api/product-prices")
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    public ProductPriceController(final ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    /**
     * Получить список всех цен продуктов
     *
     * @return ResponseEntity, содержащее список ProductPriceDTO
     */
    @GetMapping
    public ResponseEntity<List<ProductPriceDTO>> getAllProductPrices() {
        final List<ProductPrice> productPrices = productPriceService.getAllProductPrices();
        final List<ProductPriceDTO> productPriceDTOs = ProductPriceMapper.toDTOs(productPrices);
        return ResponseEntity.ok(productPriceDTOs);
    }

    /**
     * Создать новую цену продукта.
     *
     * @param productPriceDTO объект ProductPriceDTO, представляющий создаваемую цену продукта
     * @return ResponseEntity, содержащее созданный ProductPriceDTO
     */
    @PostMapping
    public ResponseEntity<ProductPriceDTO> createProductPrice(@RequestBody final ProductPriceDTO productPriceDTO) {
        final ProductPrice productPrice = ProductPriceMapper.toEntity(productPriceDTO);
        final ProductPrice savedProductPrice = productPriceService.addProductPrice(productPrice);
        final ProductPriceDTO savedProductPriceDTO = ProductPriceMapper.toDTO(savedProductPrice);
        return ResponseEntity.ok(savedProductPriceDTO);
    }

    /**
     * Получить цену продукта по ее идентификатору
     *
     * @param id идентификатор цены продукта
     * @return ResponseEntity, содержащее ProductPriceDTO цены продукта с указанным идентификатором
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductPriceDTO> getProductPriceById(@PathVariable final Long id) {
        final ProductPrice productPrice = productPriceService.getProductPriceById(id);
        final ProductPriceDTO productPriceDTO = ProductPriceMapper.toDTO(productPrice);
        return ResponseEntity.ok(productPriceDTO);
    }

    /**
     * Обновить существующую цену продукта
     *
     * @param id           идентификатор цены продукта для обновления
     * @param productPrice обновленные данные цены продукта
     * @return обновленная цена продукта
     */
    @PatchMapping("/{id}")
    public ProductPrice updateProductPrice(@PathVariable final Long id, @RequestBody final ProductPrice productPrice) {
        return productPriceService.updateProductPrice(id, productPrice);
    }

    /**
     * Удалить цену продукта по ее идентификатору
     *
     * @param id идентификатор цены продукта для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteProductPrice(@PathVariable final Long id) {
        productPriceService.deleteProductPrice(id);
    }
}
