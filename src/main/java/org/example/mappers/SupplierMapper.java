package org.example.mappers;

import org.example.dtos.SupplierDTO;
import org.example.models.Supplier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-маппер для преобразования объектов Supplier в SupplierDTO и наоборот
 */
@Component
public class SupplierMapper {

    /**
     * Преобразовать объект Supplier в SupplierDTO
     *
     * @param supplier объект Supplier
     * @return объект SupplierDTO
     */
    public static SupplierDTO toDTO(final Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        final SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        return dto;
    }

    /**
     * Преобразовать объект SupplierDTO в Supplier
     *
     * @param supplierDTO объект SupplierDTO
     * @return объект Supplier
     */
    public static Supplier toEntity(final SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }

        final Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());

        return supplier;
    }

    /**
     * Преобразовать список объектов Supplier в список объектов SupplierDTO
     *
     * @param suppliers список объектов Supplier
     * @return список объектов SupplierDTO
     */
    public static List<SupplierDTO> toDTOs(final List<Supplier> suppliers) {
        return suppliers.stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
    }
}