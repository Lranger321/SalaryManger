package main.service.calculation;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Unit;
import main.dao.entity.UnitType;
import main.dto.UnitDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AverageUnitCalculationService implements UnitCalculationService{

    @Override
    public BigDecimal calculate(UnitDTO unitDTO) {
        return basePrice;
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.AVERAGE;
    }
}
