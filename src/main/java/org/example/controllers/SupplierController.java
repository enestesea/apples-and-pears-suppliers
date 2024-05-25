package org.example.controllers;

import org.example.dtos.SupplierDTO;
import org.example.mappers.SupplierMapper;
import org.example.models.Supplier;
import org.example.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления поставщиками
 */
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * Получить список всех поставщиков
     *
     * @return список SupplierDTO
     */
    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        final List<Supplier> suppliers = supplierService.getAllSuppliers();
        return SupplierMapper.toDTOs(suppliers);
    }

    /**
     * Создать нового поставщика
     *
     * @param supplierDTO объект SupplierDTO, представляющий создаваемого поставщика
     * @return ResponseEntity, содержащее созданный SupplierDTO
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody final SupplierDTO supplierDTO) {
        final Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        final Supplier savedSupplier = supplierService.addSupplier(supplier);
        final SupplierDTO savedSupplierDTO = SupplierMapper.toDTO(savedSupplier);
        return ResponseEntity.ok(savedSupplierDTO);
    }

    /**
     * Получить поставщика по его id
     *
     * @param id идентификатор поставщика
     * @return ResponseEntity, содержащее SupplierDTO поставщика с указанным идентификатором
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable final Long id) {
        final Supplier supplier = supplierService.getSupplierById(id);
        final SupplierDTO supplierDTO = SupplierMapper.toDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    /**
     * Обновить существующего поставщика
     *
     * @param id       идентификатор поставщика для обновления
     * @param supplier обновленные данные поставщика
     * @return обновленный поставщик
     */
    @PatchMapping("/{id}")
    public Supplier updateSupplier(@PathVariable final Long id, @RequestBody final Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    /**
     * Удалить поставщика по его идентификатору
     *
     * @param id идентификатор поставщика для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable final Long id) {
        supplierService.deleteSupplier(id);
    }
}