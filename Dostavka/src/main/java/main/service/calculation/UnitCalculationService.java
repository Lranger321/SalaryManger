package main.service.calculation;

import main.dao.entity.Unit;
import main.dao.entity.UnitType;

import java.math.BigDecimal;

public interface UnitCalculationService {

    BigDecimal basePrice = BigDecimal.TEN;

    BigDecimal calculate(Unit unit);

    UnitType getUnitType();
}
