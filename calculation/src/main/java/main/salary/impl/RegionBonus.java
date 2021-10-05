package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class RegionBonus extends SalaryBonus {
    private RegionBonus(SalaryDeductionType type, BigDecimal value) {
        super(type, value);
    }

    public RegionBonus() {
        this (SalaryDeductionType.PERCENT, BigDecimal.valueOf(15));
    }
}
