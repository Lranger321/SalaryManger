package main.salary;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
public class SalaryBonus implements SalaryCalculation {

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
            return Map.of("Бонус", String.format("Бонус к запработной плате составляет %f роцентов", value.doubleValue()));
        }
        return Map.of("Бонус", String.format("Бонус к запработной плате составляет %f", value.doubleValue()));
    }

}
