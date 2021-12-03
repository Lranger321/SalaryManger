package main.service;

import main.dao.entity.UnitType;
import main.dao.repository.UnitRepository;
import main.dto.UnitDTO;
import main.service.calculation.AverageUnitCalculationService;
import main.service.calculation.SoftUnitCalculationService;
import main.service.calculation.UnitCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Tag("UnitTest")
class UnitServiceImplTest {

    private UnitServiceImpl service;

    private final AverageUnitCalculationService averageUnitCalculationService = Mockito.mock(AverageUnitCalculationService.class);

    private final SoftUnitCalculationService softUnitCalculationService = Mockito.mock(SoftUnitCalculationService.class);

    private final UnitRepository repository = Mockito.mock(UnitRepository.class);


    @BeforeEach
    void setUp() {
        Map<UnitType, UnitCalculationService> calculationServiceMap = Map.of(
                UnitType.SOFT, softUnitCalculationService,
                UnitType.AVERAGE, averageUnitCalculationService
        );
        service = new UnitServiceImpl(calculationServiceMap, repository);
        when(averageUnitCalculationService.calculate(any())).thenReturn(BigDecimal.TEN);
        when(softUnitCalculationService.calculate(any())).thenReturn(BigDecimal.ZERO);
    }

    @Test
    void calculatePriceForSoft() {
        UnitDTO unitDTO = UnitDTO.builder()
                .name("name")
                .unitType(UnitType.SOFT.getType())
                .to("TO")
                .from("from")
                .build();
        assertEquals(BigDecimal.ZERO, service.calculatePrice(unitDTO).getPrice());
    }

    @Test
    void calculatePriceForAverage() {
        UnitDTO unitDTO = UnitDTO.builder()
                .name("name")
                .unitType(UnitType.AVERAGE.getType())
                .to("TO")
                .from("from")
                .build();
        assertEquals(BigDecimal.TEN, service.calculatePrice(unitDTO).getPrice());
    }

}
