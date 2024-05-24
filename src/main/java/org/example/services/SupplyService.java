package org.example.services;

import org.example.models.Supply;
import org.example.repositories.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public Supply getSupplyById(Long id) {
        return supplyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supply not found with id: " + id));
    }

    public Supply addSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    public Supply updateSupply(Long id, Supply supply) {
        Supply existingSupply = getSupplyById(id);
        existingSupply.setSupplyDate(supply.getSupplyDate());
        existingSupply.setSupplierId(supply.getSupplierId());
        existingSupply.setProductId(supply.getProductId());
        existingSupply.setQuantity(supply.getQuantity());
        return supplyRepository.save(existingSupply);
    }

    public void deleteSupply(Long id) {
        supplyRepository.deleteById(id);
    }
}
