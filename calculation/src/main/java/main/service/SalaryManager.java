package main.service;

import main.dto.SalaryDTO;

import java.math.BigDecimal;

public interface SalaryManager {

    SalaryDTO getSalary(BigDecimal amount);

}
