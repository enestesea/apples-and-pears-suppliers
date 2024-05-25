package org.example.controllers;

import org.example.dtos.SupplyDTO;
import org.example.dtos.SupplyHolder;
import org.example.mappers.SupplyMapper;
import org.example.models.Supply;
import org.example.services.SupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Контроллер для управления поставками
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    /**
     * Получить список всех поставок
     *
     * @return ResponseEntity, содержащее список SupplyDTO
     */
    @GetMapping
    public ResponseEntity<List<SupplyDTO>> getAllSupplies() {
        final List<Supply> supplies = supplyService.getAllSupplies();
        final List<SupplyDTO> supplyDTOs = SupplyMapper.toDTOs(supplies);
        return ResponseEntity.ok(supplyDTOs);
    }

    /**
     * Получить отчёт по поставкам за указанный период
     *
     * @param startDate начальная дата периода
     * @param endDate   конечная дата периода
     * @return ResponseEntity, содержащее список SupplyHolder
     */
    @GetMapping("/report")
    public ResponseEntity<List<SupplyHolder>> getAllSuppliesByDate(@RequestParam final Date startDate, @RequestParam final Date endDate) {
        final List<SupplyHolder> supplyHolders = supplyService.getSupplyHolders(startDate, endDate);
        return ResponseEntity.ok(supplyHolders);
    }

    /**
     * Создать новую поставку
     *
     * @param supplyDTO объект SupplyDTO, представляющий создаваемую поставку
     * @return ResponseEntity, содержащее созданный SupplyDTO
     */
    @PostMapping
    public ResponseEntity<SupplyDTO> createSupply(@RequestBody final SupplyDTO supplyDTO) {
        final Supply supply = SupplyMapper.toEntity(supplyDTO);
        final Supply savedSupply = supplyService.addSupply(supply);
        final SupplyDTO savedSupplyDTO = SupplyMapper.toDTO(savedSupply);
        return ResponseEntity.ok(savedSupplyDTO);
    }

    /**
     * Создать несколько новых поставок
     *
     * @param supplyDTO список объектов SupplyDTO, представляющих создаваемые поставки
     * @return ResponseEntity, содержащее список созданных SupplyDTO
     */
    @PostMapping("/list")
    public ResponseEntity<List<SupplyDTO>> createSupply(@RequestBody final List<SupplyDTO> supplyDTO) {
        final List<Supply> supplies = SupplyMapper.toEntities(supplyDTO);
        final List<Supply> savedSupplies = supplyService.addSupplies(supplies);
        final List<SupplyDTO> savedSupplyDTOs = SupplyMapper.toDTOs(savedSupplies);
        return ResponseEntity.ok(savedSupplyDTOs);
    }

    /**
     * Получить поставку по её идентификатору
     *
     * @param id идентификатор поставки
     * @return ResponseEntity, содержащее SupplyDTO поставки с указанным идентификатором
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplyDTO> getSupplyById(@PathVariable final Long id) {
        final Supply supply = supplyService.getSupplyById(id);
        final SupplyDTO supplyDTO = SupplyMapper.toDTO(supply);
        return ResponseEntity.ok(supplyDTO);
    }

    /**
     * Обновить существующую поставку
     *
     * @param id      идентификатор поставки для обновления
     * @param supply обновленные данные поставки
     * @return обновлённая поставка
     */
    @PatchMapping("/{id}")
    public Supply updateSupply(@PathVariable final Long id, @RequestBody final Supply supply) {
        return supplyService.updateSupply(id, supply);
    }

    /**
     * Удалить поставку по её идентификатору
     *
     * @param id идентификатор поставки для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteSupply(@PathVariable final Long id) {
        supplyService.deleteSupply(id);
    }
}
