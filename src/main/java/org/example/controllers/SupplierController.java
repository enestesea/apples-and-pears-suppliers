package org.example.controllers;

import org.example.dtos.SupplierDTO;
import org.example.mappers.SupplierMapper;
import org.example.models.Supplier;
import org.example.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        final List<Supplier> suppliers = supplierService.getAllSuppliers();
        final List<SupplierDTO> supplierDTOs = SupplierMapper.toDTOs(suppliers);
        return ResponseEntity.ok(supplierDTOs);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        final Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        final Supplier savedSupplier = supplierService.addSupplier(supplier);
        final SupplierDTO savedSupplierDTO = SupplierMapper.toDTO(savedSupplier);
        return ResponseEntity.ok(savedSupplierDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        final Supplier supplier = supplierService.getSupplierById(id);
        final SupplierDTO supplierDTO = SupplierMapper.toDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }


    @PatchMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }
}