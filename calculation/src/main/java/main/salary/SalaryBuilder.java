package main.salary;

import java.math.BigDecimal;

public class SalaryBuilder {

    private final BigDecimal amount;

    public SalaryBuilder() {
        this(BigDecimal.ZERO);
    }

    public SalaryBuilder(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal build() {
        return amount;
    }

    public SalaryBuilder add(SalaryCalculation calculation) {
        return this;
    }
}
