package main.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private UnitType type;

    private BigDecimal price;

    @Column(name = "unit_from", nullable = false)
    private String from;

    @Column(name = "unit_to", nullable = false)
    private String to;

    private Double weight;

    @Column(name = "speed_type")
    private SpeedType speedType;
}
