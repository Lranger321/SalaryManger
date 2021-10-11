package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class RegionBonus extends SalaryBonus {
    public RegionBonus() {
        super(SalaryDeductionType.PERCENT, BigDecimal.valueOf(15));
    }
}
