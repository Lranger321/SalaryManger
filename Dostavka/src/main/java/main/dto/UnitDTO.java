package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UnitDTO {

    private String name;
    private String unitType;
    private String speedType;
    private Double weight;
    private String from;
    private String to;
}
