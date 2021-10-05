package main.salary;

import main.dto.SalaryDTO;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SalaryBuilder {

    private final List<Map<String, String>> annotation;
    private BigDecimal amount;

    public SalaryBuilder() {
        this(BigDecimal.ZERO);
    }

    public SalaryBuilder(BigDecimal amount) {
        this.amount = amount;
        this.annotation = new LinkedList<>();
    }

    public SalaryDTO build() {
        return new SalaryDTO(amount, annotation);
    }

    public SalaryBuilder add(SalaryCalculation calculation) {
        amount = calculation.add(amount);
        annotation.add(calculation.getAnnotation());
        return this;
    }
}
