package org.example.mappers;

import org.example.dtos.ProductDTO;
import org.example.dtos.SupplyDTO;
import org.example.models.Product;
import org.example.models.Supply;
import org.example.models.Type;

import java.util.List;
import java.util.stream.Collectors;

public class SupplyMapper {

    public static SupplyDTO toDTO(Supply supply) {
        if (supply == null) {
            return null;
        }

        SupplyDTO supplyDTO = new SupplyDTO();
        supplyDTO.setId(supply.getId());
        supplyDTO.setQuantity(supply.getQuantity());
        supplyDTO.setSupplyDate(supply.getSupplyDate());
        supplyDTO.setProductId(supply.getProductId());
        supplyDTO.setSupplierId(supply.getSupplierId());

        return supplyDTO;
    }

    public static Supply toEntity(SupplyDTO supplyDTO) {
        if (supplyDTO == null) {
            return null;
        }

        Supply supply = new Supply();
        supply.setId(supplyDTO.getId());
        supply.setQuantity(supplyDTO.getQuantity());
        supply.setSupplyDate(supplyDTO.getSupplyDate());
        supply.setProductId(supplyDTO.getProductId());
        supply.setSupplierId(supplyDTO.getSupplierId());

        return supply;
    }

    public static List<SupplyDTO> toDTOs(List<Supply> supplys) {
        List<SupplyDTO> supplyDTOs = supplys.stream()
                .map(SupplyMapper::toDTO)
                .collect(Collectors.toList());
        return supplyDTOs;

    }
}

