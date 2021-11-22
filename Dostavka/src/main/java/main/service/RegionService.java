package main.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegionService {

    // кринж логика можно поправить
    public BigDecimal regionBonus(String to) {
        return (!Character.isLowerCase(to.charAt(0))) ? BigDecimal.TEN : BigDecimal.ONE;
    }
}
