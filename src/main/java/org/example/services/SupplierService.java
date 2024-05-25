package org.example.services;

import org.example.models.Supplier;
import org.example.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с поставщиками
 */
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(final SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    /**
     * Получить список всех поставщиков
     *
     * @return список всех поставщиков
     */
    public final List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    /**
     * Получить поставщика по его идентификатору
     *
     * @param id идентификатор поставщика
     * @return поставщик с указанным идентификатором
     * @throws IllegalArgumentException если поставщик с указанным идентификатором не найден
     */
    public final Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with id: " + id));
    }

    /**
     * Добавить нового поставщика
     *
     * @param supplier новый поставщик
     * @return сохраненный поставщик
     */
    public final Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    /**
     * Обновить информацию о поставщике
     *
     * @param id       идентификатор поставщика, который нужно обновить
     * @param supplier новая информация о поставщике
     * @return обновленный поставщик
     * @throws IllegalArgumentException если поставщик с указанным идентификатором не найден
     */
    public final Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier = getSupplierById(id);
        existingSupplier.setName(supplier.getName());
        return supplierRepository.save(existingSupplier);
    }

    /**
     * Удалить поставщика по его id
     *
     * @param id идентификатор поставщика, который нужно удалить
     */
    public final void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}