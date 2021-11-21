package main.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UnitType {
    SOFT("soft"),
    AVERAGE("average"),
    GRAVE("grave");

    private String type;

    //@todo Убрать null
    public static UnitType getType(String value) {
        for (UnitType type : UnitType.values()) {
            if (type.getType().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
