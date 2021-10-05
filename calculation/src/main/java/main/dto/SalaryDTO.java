package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Builder
@AllArgsConstructor
@Getter
public class SalaryDTO {

    private BigDecimal amount;
    private Map<String, String> salaryInfo;

}
