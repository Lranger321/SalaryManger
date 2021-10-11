package main.salary.impl;

import main.salary.SalaryDeduction;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;
import java.util.Map;

public class NDFLDeduction extends SalaryDeduction {
    public NDFLDeduction() {
        super(SalaryDeductionType.PERCENT, BigDecimal.valueOf(13));
    }
}

