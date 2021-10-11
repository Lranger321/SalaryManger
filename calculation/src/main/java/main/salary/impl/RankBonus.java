package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class RankBonus extends SalaryBonus {
    public RankBonus(BigDecimal value) {
        super(SalaryDeductionType.PERCENT, value);
    }
}
