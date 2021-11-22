package main.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SpeedType {
    EMERGENCY("emergency"),
    FAST("fast");

    private String type;

    //@todo Убрать null
    public static SpeedType getType(String value) {
        for (SpeedType type : SpeedType.values()) {
            if (type.getType().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
