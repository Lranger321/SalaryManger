package main.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegionService {

    public BigDecimal regionBonus(String to){
        return BigDecimal.ONE;
    }
}
