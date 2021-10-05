package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class RankBonus extends SalaryBonus {
    private RankBonus(SalaryDeductionType type, BigDecimal value) {
        super(type, value);
    }

    public RankBonus(BigDecimal value) {
        this (SalaryDeductionType.PERCENT, value);
    }
}
