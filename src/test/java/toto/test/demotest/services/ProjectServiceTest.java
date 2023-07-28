package toto.test.demotest.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    private ProjectService service = new ProjectService();

    @Test
    public void givenNothing_whenAll_ThenReturnInt() {
        // Arrange
        int expected = 2;

        // Act
        int result = service.all().size();

        // Assert
        assertEquals(expected,result);
    }
}
