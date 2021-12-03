package main.service;

import main.dao.entity.Unit;
import main.dao.repository.UnitRepository;
import main.dto.UnitDTO;
import main.exception.UnitNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {UnitControllerTest.Initializer.class})
class UnitControllerTest {

    @Autowired
    private UnitServiceImpl service;

    private static final UnitDTO UNIT_DTO = UnitDTO.builder()
            .name("name")
            .unitType("soft")
            .to("to")
            .from("from")
            .weight(20.0)
            .speedType("emergency")
            .build();

    private static final UnitDTO NEW_UNIT_DTO = UnitDTO.builder()
            .name("name1")
            .unitType("soft")
            .to("to")
            .from("from")
            .weight(21.0)
            .speedType("fast")
            .build();

    @Test
    void addUnit() {
        long id = service.saveUnit(UNIT_DTO).getId();
        Unit unit = service.getById(id);
        assertEquals(UNIT_DTO.getName(), unit.getName());
        assertEquals(UNIT_DTO.getUnitType(), unit.getType().getType());
        assertEquals(UNIT_DTO.getFrom(), unit.getFrom());
        assertEquals(UNIT_DTO.getTo(), unit.getTo());
        assertEquals(UNIT_DTO.getSpeedType(), unit.getSpeedType().getType());
    }

    @Test
    void deleteUnit() {
        long id = service.saveUnit(UNIT_DTO).getId();
        service.deleteById(id);
        assertThrows(UnitNotFoundException.class, () -> service.getById(id));
    }

    @Test
    void updateUnit() {
        long id = service.saveUnit(UNIT_DTO).getId();
        service.updateUnit(id, NEW_UNIT_DTO);
        Unit unit = service.getById(id);
        assertEquals(NEW_UNIT_DTO.getName(), unit.getName());
        assertEquals(NEW_UNIT_DTO.getUnitType(), unit.getType().getType());
        assertEquals(NEW_UNIT_DTO.getFrom(), unit.getFrom());
        assertEquals(NEW_UNIT_DTO.getTo(), unit.getTo());
        assertEquals(NEW_UNIT_DTO.getSpeedType(), unit.getSpeedType().getType());
    }

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12")
            .withDatabaseName("project")
            .withPassword("postgres")
            .withUsername("root");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "datasource.db-reference-data.hikari.jdbc-url=" + postgreSQLContainer.getJdbcUrl()
            ).applyTo(applicationContext.getEnvironment());
        }
    }
}
