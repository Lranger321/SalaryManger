package main.service.impl;

import main.dto.SalaryDTO;
import main.salary.SalaryBuilder;
import main.salary.SalaryDeduction;
import main.salary.impl.EnglishBonus;
import main.salary.impl.NDFLDeduction;
import main.salary.impl.RankBonus;
import main.salary.impl.RegionBonus;
import main.service.SalaryManager;

import java.math.BigDecimal;

public class SalaryManagerImpl implements SalaryManager {
    @Override
    public SalaryDTO getSalary(BigDecimal amount) {
        return new SalaryBuilder()
                .add(new NDFLDeduction())
//                .add(new RankBonus())
//                .add(new ConditionBonus())
//                .add(new StateSecretBonus())
//                .add(new AwardBonus())
//                .add(new ExperienceBonus())
                .add(new RegionBonus())
                .add(new EnglishBonus())
                .build();
    }

}
