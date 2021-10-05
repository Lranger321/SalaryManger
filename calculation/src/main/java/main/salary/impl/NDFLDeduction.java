package main.salary.impl;

import main.salary.SalaryDeduction;
import main.salary.SalaryDeductionType;

import java.math.BigDecimal;
import java.util.Map;

public class NDFLDeduction extends SalaryDeduction {
    private NDFLDeduction(SalaryDeductionType type, BigDecimal value) {
        super(type, value);
    }

    public NDFLDeduction() {
        this (SalaryDeductionType.PERCENT, BigDecimal.valueOf(13));
    }

    @Override
    public Map<String, String> getAnnotation() {
        return super.getAnnotation();
    }
}

