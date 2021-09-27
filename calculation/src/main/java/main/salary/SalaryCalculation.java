package main.salary;

import java.math.BigDecimal;

public interface SalaryCalculation {

    BigDecimal add(SalaryDeductionType type, BigDecimal amount);

}
