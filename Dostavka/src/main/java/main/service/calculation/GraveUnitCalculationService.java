package main.service.calculation;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Unit;
import main.dao.entity.UnitType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GraveUnitCalculationService implements UnitCalculationService{

    @Override
    public BigDecimal calculate(Unit unit) {
        return null;
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.GRAVE;
    }
}
