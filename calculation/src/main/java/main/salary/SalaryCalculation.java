package main.salary;

import java.math.BigDecimal;
import java.util.Map;

public interface SalaryCalculation {

    BigDecimal add(BigDecimal amount);

    Map<String, String> getAnnotation();

}
