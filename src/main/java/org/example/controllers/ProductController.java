package org.example.controllers;

import org.example.dtos.ProductDTO;
import org.example.mappers.ProductMapper;
import org.example.models.Product;
import org.example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления продуктами
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    /**
     * Получить список всех продуктов
     *
     * @return ResponseEntity, содержащее список ProductDTO
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        final List<Product> products = productService.getAllProducts();
        final List<ProductDTO> productDTOs = ProductMapper.toDTOs(products);
        return ResponseEntity.ok(productDTOs);
    }

    /**
     * Создать новый продукт
     *
     * @param productDTO объект ProductDTO, представляющий создаваемый продукт
     * @return ResponseEntity, содержащее созданный ProductDTO
     */
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody final ProductDTO productDTO) {
        final Product product = ProductMapper.toEntity(productDTO);
        final Product savedProduct = productService.addProduct(product);
        final ProductDTO savedProductDTO = ProductMapper.toDTO(savedProduct);
        return ResponseEntity.ok(savedProductDTO);
    }

    /**
     * Получить продукт по его идентификатору
     *
     * @param id идентификатор продукта
     * @return ResponseEntity, содержащее ProductDTO продукта с указанным идентификатором
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable final Long id) {
        final Product product = productService.getProductById(id);
        final ProductDTO productDTO = ProductMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);
    }

    /**
     * Обновить существующий продукт
     *
     * @param id      идентификатор продукта для обновления
     * @param product обновленные данные продукта
     * @return обновленный продукт
     */
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable final Long id, @RequestBody final Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Удалить продукт по его id
     *
     * @param id идентификатор продукта для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }
}
