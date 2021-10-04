package main.salary;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class SalaryDeduction implements SalaryCalculation {

    private final SalaryDeductionType type;
    private final BigDecimal value;

    @Override
    public BigDecimal add(BigDecimal amount) {
        return amount.add(type.equals(SalaryDeductionType.PERCENT) ?
                BigDecimal.valueOf(value.doubleValue() * amount.doubleValue()) : value);
    }

}
