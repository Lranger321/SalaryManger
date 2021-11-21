package main.service.calculation;

import lombok.RequiredArgsConstructor;
import main.dao.entity.UnitType;
import main.dto.UnitDTO;
import main.service.RegionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SoftUnitCalculationService implements UnitCalculationService {

    private final RegionService regionService;

    @Override
    public BigDecimal calculate(UnitDTO unitDTO) {
        return basePrice.add(regionService.regionBonus(unitDTO.getTo()));
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.SOFT;
    }
}
