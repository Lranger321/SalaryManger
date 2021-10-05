package main.salary;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
public class SalaryDeduction implements SalaryCalculation {

    private final SalaryDeductionType type;
    private final BigDecimal value;

    @Override
    public BigDecimal add(BigDecimal amount) {
        return amount.add(type.equals(SalaryDeductionType.PERCENT) ?
                BigDecimal.valueOf(value.doubleValue() * amount.doubleValue()) : value);
    }

    @Override
    public Map<String, String> getAnnotation() {
        if (type.equals(SalaryDeductionType.PERCENT)) {
            return Map.of("Вычет", String.format("Вычет из запработной платы составляет %f процентов", value.doubleValue()));
        }
        return Map.of("Вычет", String.format("Вычет из запработной платы составляет %f", value.doubleValue()));
    }

}
