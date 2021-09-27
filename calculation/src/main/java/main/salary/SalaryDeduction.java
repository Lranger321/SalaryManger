package main.salary;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class SalaryDeduction implements SalaryCalculation {

    private BigDecimal amount;

    @Override
    public BigDecimal add(SalaryDeductionType type, BigDecimal value) {
        return amount.add(type.equals(SalaryDeductionType.PERCENT) ?
                BigDecimal.valueOf(value.doubleValue() * amount.doubleValue()) : value);
    }

}
