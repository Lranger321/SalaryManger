package main.config;

import main.dao.entity.UnitType;
import main.service.calculation.UnitCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class UnitCalculationConfig {

    @Bean
    public Map<UnitType, UnitCalculationService> unitCalculationServiceMap(@Autowired List<UnitCalculationService> services) {
        return services.stream().collect(Collectors.toMap(UnitCalculationService::getUnitType,
                unitCalculationService -> unitCalculationService));
    }
}
