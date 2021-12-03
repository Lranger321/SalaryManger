package main.controller;

import lombok.AllArgsConstructor;
import main.dao.entity.Unit;
import main.dto.UnitDTO;
import main.dto.UnitPriceDTO;
import main.service.UnitServiceImpl;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController("/api/units")
public class UnitController {

    private final UnitServiceImpl unitService;

    @PostMapping
    public UnitPriceDTO getPrice(UnitDTO dto) {
        return unitService.calculatePrice(dto);
    }

    @PostMapping("/")
    public Unit addUnit(UnitDTO dto) {
        return unitService.saveUnit(dto);
    }

    @DeleteMapping("/")
    public void deleteUnit(long id) {
        unitService.deleteById(id);
    }

    @GetMapping("{id}")
    public Unit getById(@PathVariable long id) {
        return unitService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateUnit(@PathVariable long id, UnitDTO dto) {
        unitService.updateUnit(id, dto);
    }
}
