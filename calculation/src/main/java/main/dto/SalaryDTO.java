package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class SalaryDTO {

    private BigDecimal amount;
    private List<SalaryInfoDTO> salaryInfo;

    public static class SalaryInfoDTO {

        private BigDecimal percents;
        private String info;
    }
}
