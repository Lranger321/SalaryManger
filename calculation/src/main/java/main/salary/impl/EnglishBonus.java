package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class EnglishBonus extends SalaryBonus {
    public EnglishBonus(SalaryDeductionType type, BigDecimal value) {
        super(type, value);
    }

    public EnglishBonus() {
        this (SalaryDeductionType.PERCENT, BigDecimal.valueOf(20));
    }

}
