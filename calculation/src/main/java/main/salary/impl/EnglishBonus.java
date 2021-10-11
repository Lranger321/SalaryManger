package main.salary.impl;

import main.salary.SalaryBonus;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;

public class EnglishBonus extends SalaryBonus {
    public EnglishBonus()
    {
        super(SalaryDeductionType.PERCENT, BigDecimal.valueOf(20));
    }

}
