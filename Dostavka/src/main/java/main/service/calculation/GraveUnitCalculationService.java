package main.service.calculation;

import lombok.RequiredArgsConstructor;
import main.dao.entity.UnitType;
import main.dto.UnitDTO;
import main.service.RegionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GraveUnitCalculationService implements UnitCalculationService {

    private final RegionService regionService;

    @Override
    public BigDecimal calculate(UnitDTO unitDTO) {
        return basePrice.add(regionService.regionBonus(unitDTO.getTo()))
                .add(getByWeight(unitDTO.getWeight()));
    }

    private BigDecimal getByWeight(Double weight) {
        return new BigDecimal(weight / 100);
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.GRAVE;
    }
}
