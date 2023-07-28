package toto.test.demotest.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toto.test.demotest.models.Project;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    private final ProjectService service = new ProjectService();

    @BeforeEach
    public void setup() {
        service.setListeProject(new ArrayList<>(
                List.of(
                        new Project(1L, "Jenkins"),
                        new Project(2L, "Maven")
                )
        ));
    }

    @AfterEach
    public void clean() {
        service.setListeProject(new ArrayList<>());
    }

    @Test
    public void givenNothing_whenAll_ThenReturnInt() {
        // Arrange
        int expected = 2;

        // Act
        int result = service.all().size();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    public void givenExistingId_whenById_ThenReturnProject() {
        long id = 1L;

        Project result = service.byId(id);

        assertNotNull(result);
    }
}
