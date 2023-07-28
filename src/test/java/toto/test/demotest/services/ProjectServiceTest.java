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
    void givenNothing_whenAll_ThenReturnInt() {
        // Arrange
        int expected = 2;

        // Act
        int result = service.all().size();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void givenExistingId_whenById_ThenReturnProject() {
        long id = 1L;

        Project result = service.byId(id);

        assertNotNull(result);
    }

    @Test
    void givenExistingId_whenById_ThenExpectName() {
        long id = 1L;
        String expectedName = "Jenkins";
        Project result = service.byId(id);

        assertEquals(expectedName,result.getName());
    }

    @Test
    void givenAnotherExistingId_whenById_ThenExpectName() {
        long id = 2L;
        String expectedName = "Maven";
        Project result = service.byId(id);

        assertEquals(expectedName,result.getName());
    }

    @Test
    void givenNonExistingId_whenById_ThenReturnProject() {
        long id = 0L;
        Project result = service.byId(id);

        assertNotNull(result);
    }

    @Test
    void givenProjectWithId0_whenSaveOrUpdate_thenAddToList() {
        Project toSave = new Project(0L,"Docker");
        int expectedListSize = 3;
        long expectedSavedId = 3L;

        Project result = service.saveOrUpdate(toSave);

        assertAll(
                () -> assertEquals(expectedListSize, service.listeProject.size()),
                () -> assertEquals(expectedSavedId, result.getId()),
                () -> assertEquals(result.getId(), toSave.getId())
        );
    }

    @Test
    void givenProjectWithExistingId_whenSaveOrUpdate_thenUpdateProject() {
        Project toSave = new Project(1L,"Jenkins with Docker");
        int expectedListSize = 2;
        long expectedSavedId = 1L;

        Project result = service.saveOrUpdate(toSave);

        assertAll(
                () -> assertEquals(expectedListSize, service.listeProject.size()),
                () -> assertEquals(expectedSavedId, result.getId()),
                () -> assertEquals( toSave.getName(), result.getName()),
                () -> assertTrue(
                        service.listeProject.stream()
                                .filter(project -> project.getId() == toSave.getId()).findFirst()
                                .map(project -> project.getName().equals(toSave.getName()))
                                .orElse(false))
        );
    }

    @Test
    void givenProjectWithNonExistingId_whenSaveOrUpdate_thenAddToList() {
        Project toSave = new Project(5L,"Docker");
        int expectedListSize = 3;
        long expectedSavedId = 3L;

        Project result = service.saveOrUpdate(toSave);

        assertAll(
                () -> assertEquals(expectedListSize, service.listeProject.size()),
                () -> assertEquals(expectedSavedId, result.getId()),
                () -> assertEquals(result.getId(), toSave.getId())
        );
    }


    @Test
    void givenProjectWithId0_whenSaveOrUpdate_thenAddAlreadyIncrementedList() {
        Project toSave = new Project(0L,"Docker");
        service.listeProject.add(new Project(3L, "Spring"));
        int expectedListSize = 4;
        long expectedSavedId = 4L;

        Project result = service.saveOrUpdate(toSave);

        assertAll(
                () -> assertEquals(expectedListSize, service.listeProject.size()),
                () -> assertEquals(expectedSavedId, result.getId()),
                () -> assertEquals(result.getId(), toSave.getId())
        );
    }

    @Test
    void givenExistingId_whenDeleteById_thenRemoveFromList() {
        long toRemove = 1L;
        int expectedListSize = 1;
        service.deleteById(toRemove);

        assertEquals(expectedListSize, service.listeProject.size());
    }


    @Test
    void givenNonExistingId_whenDeleteById_thenListIsUnchanged() {
        long toRemove = 0L;
        int expectedListSize = 2;
        service.deleteById(toRemove);

        assertEquals(expectedListSize, service.listeProject.size());
    }
}
