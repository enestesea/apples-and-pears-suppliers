package org.example.services;

import org.example.models.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с продуктами
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Получить список всех продуктов
     *
     * @return список всех продуктов
     */
    public final List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Получить продукт по его идентификатору
     *
     * @param id идентификатор продукта
     * @return продукт с указанным идентификатором
     * @throws IllegalArgumentException если продукт с указанным идентификатором не найден
     */
    public final Product getProductById(final Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
    }

    /**
     * Добавить новый продукт
     *
     * @param product новый продукт
     * @return сохраненный продукт
     */
    public final Product addProduct(final Product product) {
        return productRepository.save(product);
    }

    /**
     * Обновить информацию о продукте
     *
     * @param id      идентификатор продукта, который нужно обновить
     * @param product новая информация о продукте
     * @return обновленный продукт
     * @throws IllegalArgumentException если продукт с указанным идентификатором не найден
     */
    public final Product updateProduct(final Long id, final Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        return productRepository.save(existingProduct);
    }

    /**
     * Удалить продукт по его идентификатору
     *
     * @param id идентификатор продукта, который нужно удалить
     */
    public final void deleteProduct(final Long id) {
        productRepository.deleteById(id);
    }
}
