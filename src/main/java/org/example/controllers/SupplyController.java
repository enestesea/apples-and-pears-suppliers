package org.example.controllers;

import org.example.dtos.SupplyDTO;
import org.example.mappers.SupplyMapper;
import org.example.models.Supply;
import org.example.services.SupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping
    public ResponseEntity<List<SupplyDTO>> getAllSupplies() {
        final List<Supply> supplies = supplyService.getAllSupplies();
        final List<SupplyDTO> supplyDTOs = SupplyMapper.toDTOs(supplies);
        return ResponseEntity.ok(supplyDTOs);
    }

    @PostMapping
    public ResponseEntity<SupplyDTO> createSupply(@RequestBody SupplyDTO supplyDTO) {
        final Supply supply = SupplyMapper.toEntity(supplyDTO);
        final Supply savedSupply = supplyService.addSupply(supply);
        final SupplyDTO savedSupplyDTO = SupplyMapper.toDTO(savedSupply);
        return ResponseEntity.ok(savedSupplyDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyDTO> getSupplyById(@PathVariable Long id) {
        final Supply supply = supplyService.getSupplyById(id);
        final SupplyDTO supplyDTO = SupplyMapper.toDTO(supply);
        return ResponseEntity.ok(supplyDTO);
    }


    @PatchMapping("/{id}")
    public Supply updateSupply(@PathVariable Long id, @RequestBody Supply supply) {
        return supplyService.updateSupply(id, supply);
    }

    @DeleteMapping("/{id}")
    public void deleteSupply(@PathVariable Long id) {
        supplyService.deleteSupply(id);
    }
}