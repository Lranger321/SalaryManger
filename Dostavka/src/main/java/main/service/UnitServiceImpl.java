package main.service;

import lombok.RequiredArgsConstructor;
import main.dao.entity.SpeedType;
import main.dao.entity.Unit;
import main.dao.entity.UnitType;
import main.dao.repository.UnitRepository;
import main.dto.UnitDTO;
import main.dto.UnitPriceDTO;
import main.service.calculation.UnitCalculationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl {

    private final Map<UnitType, UnitCalculationService> calculationServiceMap;
    private final UnitRepository unitRepository;

    public UnitPriceDTO calculatePrice(UnitDTO unitDTO) {
        UnitCalculationService calculationService = getCalculationService(unitDTO);
        return new UnitPriceDTO(calculationService.calculate(unitDTO));
    }


    private UnitCalculationService getCalculationService(UnitDTO unitDTO) {
        return calculationServiceMap.get(UnitType.getType(unitDTO.getUnitType()));
    }

    @Transactional
    public long saveUnit(UnitDTO unitDTO){
        return unitRepository.save(fromDto(unitDTO)).getId();
    }

    //@todo обработка null
    public Unit getById(long id){
        return unitRepository.findById(id).get();
    }

    private Unit fromDto(UnitDTO unitDTO){
        return Unit.builder()
                .from(unitDTO.getFrom())
                .to(unitDTO.getTo())
                .name(unitDTO.getName())
                .price(calculatePrice(unitDTO).getPrice())
                .speedType(SpeedType.getType(unitDTO.getSpeedType()))
                .type(UnitType.getType(unitDTO.getUnitType()))
                .build();
    }

}
