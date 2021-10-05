package main.salary;

import main.dto.SalaryDTO;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class SalaryBuilder {

    private BigDecimal amount;
    private final Map<String, String> annotation;

    public SalaryBuilder() {
        this(BigDecimal.ZERO);
    }

    public SalaryBuilder(BigDecimal amount) {
        this.amount = amount;
        this.annotation = new LinkedHashMap<>();
    }

    public SalaryDTO build() {
        return new SalaryDTO(amount, annotation);
    }

    public SalaryBuilder add(SalaryCalculation calculation) {
        amount = calculation.add(amount);
        annotation.putAll(calculation.getAnnotation());
        return this;
    }
}
