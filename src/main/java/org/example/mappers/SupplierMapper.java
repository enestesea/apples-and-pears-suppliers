package org.example.mappers;

import org.example.dtos.ProductDTO;
import org.example.dtos.SupplierDTO;
import org.example.models.Product;
import org.example.models.Supplier;
import org.example.models.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        return dto;
    }
    public static Supplier toEntity(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());

        return supplier;
    }
    public static List<SupplierDTO> toDTOs(List<Supplier> suppliers) {
        List<SupplierDTO> supplierDTOS = suppliers.stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
        return supplierDTOS;

    }
}

