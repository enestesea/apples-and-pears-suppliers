package org.example.services;

import org.example.models.ProductPrice;
import org.example.repositories.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с ценами продуктов
 */
@Service
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceService(final ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    /**
     * Получить список всех цен на продукты
     *
     * @return список всех цен на продукты
     */
    public final List<ProductPrice> getAllProductPrices() {
        return productPriceRepository.findAll();
    }

    /**
     * Получить цену продукта по его id
     *
     * @param id идентификатор цены продукта
     * @return цена продукта с указанным идентификатором
     * @throws IllegalArgumentException если цена продукта с указанным идентификатором не найдена
     */
    public final ProductPrice getProductPriceById(final Long id) {
        return productPriceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductPrice not found with id: " + id));
    }

    /**
     * Добавить новую цену продукта
     *
     * @param productPrice новая цена продукта
     * @return сохраненная цена продукта
     */
    public final ProductPrice addProductPrice(final ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    /**
     * Обновить информацию о цене продукта
     *
     * @param id           идентификатор цены продукта, которую нужно обновить
     * @param productPrice новая информация о цене продукта
     * @return обновленная цена продукта
     * @throws IllegalArgumentException если цена продукта с указанным идентификатором не найдена
     */
    public final ProductPrice updateProductPrice(final Long id, final ProductPrice productPrice) {
        final ProductPrice existingProductPrice = getProductPriceById(id);
        existingProductPrice.setEndDate(productPrice.getEndDate());
        existingProductPrice.setStartDate(productPrice.getStartDate());
        existingProductPrice.setProductId(productPrice.getProductId());
        existingProductPrice.setSupplierId(productPrice.getSupplierId());
        existingProductPrice.setPrice(productPrice.getPrice());
        return productPriceRepository.save(existingProductPrice);
    }

    /**
     * Удалить цену продукта по  id.
     *
     * @param id идентификатор цены продукта, которую нужно удалить
     */
    public final void deleteProductPrice(final Long id) {
        productPriceRepository.deleteById(id);
    }
}