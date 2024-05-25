package org.example.services;

import org.example.dtos.SupplyHolder;
import org.example.models.Product;
import org.example.models.Supplier;
import org.example.models.Supply;
import org.example.repositories.ProductPriceRepository;
import org.example.repositories.ProductRepository;
import org.example.repositories.SupplierRepository;
import org.example.repositories.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с поставками
 */
@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplyService(final SupplyRepository supplyRepository, final ProductPriceRepository productPriceRepository,
                         final ProductRepository productRepository, final SupplierRepository supplierRepository) {
        this.supplyRepository = supplyRepository;
        this.productPriceRepository = productPriceRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    /**
     * Получить список всех поставок
     *
     * @return список всех поставок
     */
    public final List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    /**
     * Получить список всех поставок в заданном временном интервале
     *
     * @param startDate начальная дата интервала
     * @param endDate   конечная дата интервала
     * @return список всех поставок в указанном временном интервале
     */
    public final List<Supply> getAllSuppliesBetweenDates(Date startDate, Date endDate) {
        return supplyRepository.getSuppliesBySupplyDateIsBetween(startDate, endDate);
    }

    /**
     * Получить поставку по ее id.
     *
     * @param id идентификатор поставки
     * @return поставка с указанным идентификатором
     * @throws IllegalArgumentException если поставка с указанным идентификатором не найдена
     */
    public final Supply getSupplyById(final Long id) {
        return supplyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supply not found with id: " + id));
    }

    /**
     * Добавить новую поставку.
     *
     * @param supply новая поставка
     * @return сохраненная поставка
     */
    public final Supply addSupply(final Supply supply) {
        this.fillPriceInSupply(supply);
        return supplyRepository.save(supply);
    }

    /**
     * Добавить список новых поставок
     *
     * @param supplies список новых поставок
     * @return список сохраненных поставок
     */
    public final List<Supply> addSupplies(final List<Supply> supplies) {
        for (final Supply supply : supplies) {
            this.fillPriceInSupply(supply);
        }
        return supplyRepository.saveAll(supplies);
    }

    /**
     * Заполнить цену в поставке на основе цены продукта
     *
     * @param supply поставка, для которой необходимо заполнить цену
     */
    private void fillPriceInSupply(Supply supply) {
        supply.setPrice(productPriceRepository.findPrice(supply.getSupplyDate(), supply.getProductId(), supply.getSupplierId()) * supply.getQuantity());
    }

    /**
     * Получить список объектов содержащих информацию о поставках между заданными датами
     *
     * @param startDate начальная дата интервала
     * @param endDate   конечная дата интервала
     * @return список объектов с информацией о поставках
     */
    public final List<SupplyHolder> getSupplyHolders(final Date startDate, final Date endDate) {
        final List<Supply> supplies = getAllSuppliesBetweenDates(startDate, endDate);
        return supplies.stream().map(this::fillSupplyHolder).collect(Collectors.toList());
    }

    /**
     * Заполнить объект информацией о поставке
     *
     * @param supply поставка, для которой необходимо заполнить информацию
     * @return объект с информацией о поставке
     */
    private SupplyHolder fillSupplyHolder(final Supply supply) {
        try {
            final Product product = productRepository.findById(supply.getProductId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
            final Supplier supplier = supplierRepository.findById(supply.getSupplierId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
            return new SupplyHolder(supply, product.getName(), supplier.getName());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Обновить информацию о поставке
     *
     * @param id     идентификатор поставки, которую нужно обновить
     * @param supply новая информация о поставке
     * @return обновленная поставка
     */
    public final Supply updateSupply(final Long id, final Supply supply) {
        Supply existingSupply = getSupplyById(id);
        existingSupply.setSupplyDate(supply.getSupplyDate());
        existingSupply.setSupplierId(supply.getSupplierId());
        existingSupply.setProductId(supply.getProductId());
        existingSupply.setQuantity(supply.getQuantity());
        return supplyRepository.save(existingSupply);
    }

    /**
     * Удалить поставку по ее id
     *
     * @param id идентификатор поставки, которую нужно удалить
     */
    public final void deleteSupply(Long id) {
        supplyRepository.deleteById(id);
    }
}