package main.salary;

import main.dto.SalaryDTO;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryBuilderTest {

    @Test
    public void calculate() {
        SalaryDTO salary = new SalaryBuilder()
                .add(new SalaryBonus(SalaryDeductionType.AMOUNT, BigDecimal.TEN))
                .add(new SalaryBonus(SalaryDeductionType.AMOUNT, BigDecimal.ONE))
                .add(new SalaryDeduction(SalaryDeductionType.AMOUNT, BigDecimal.TEN))
                .build();
        assertEquals(BigDecimal.ONE, salary.getAmount());
        assertEquals(3, salary.getSalaryInfo().size());
    }

}