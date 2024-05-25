package org.example.mappers;

import org.example.dtos.SupplyDTO;
import org.example.models.Supply;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-маппер для преобразования объектов Supply в SupplyDTO и наоборот
 */
public class SupplyMapper {

    /**
     * Преобразовать объект Supply в SupplyDTO
     *
     * @param supply объект Supply
     * @return объект SupplyDTO
     */
    public static SupplyDTO toDTO(final Supply supply) {
        if (supply == null) {
            return null;
        }

        final SupplyDTO supplyDTO = new SupplyDTO();
        supplyDTO.setId(supply.getId());
        supplyDTO.setQuantity(supply.getQuantity());
        supplyDTO.setSupplyDate(supply.getSupplyDate());
        supplyDTO.setProductId(supply.getProductId());
        supplyDTO.setSupplierId(supply.getSupplierId());

        return supplyDTO;
    }

    /**
     * Преобразовать объект SupplyDTO в Supply.
     *
     * @param supplyDTO объект SupplyDTO
     * @return объект Supply
     */
    public static Supply toEntity(final SupplyDTO supplyDTO) {
        if (supplyDTO == null) {
            return null;
        }

        final Supply supply = new Supply();
        supply.setId(supplyDTO.getId());
        supply.setQuantity(supplyDTO.getQuantity());
        supply.setSupplyDate(supplyDTO.getSupplyDate());
        supply.setProductId(supplyDTO.getProductId());
        supply.setSupplierId(supplyDTO.getSupplierId());

        return supply;
    }

    /**
     * Преобразовать список объектов Supply в список объектов SupplyDTO.
     *
     * @param supplies список объектов Supply
     * @return список объектов SupplyDTO
     */
    public static List<SupplyDTO> toDTOs(final List<Supply> supplies) {
        return supplies.stream()
                .map(SupplyMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Преобразовать список объектов SupplyDTO в список объектов Supply.
     *
     * @param supplies список объектов SupplyDTO
     * @return список объектов Supply
     */
    public static List<Supply> toEntities(List<SupplyDTO> supplies) {
        return supplies.stream()
                .map(SupplyMapper::toEntity)
                .collect(Collectors.toList());
    }
}