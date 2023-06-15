package UseCases;

import DBcontroller.DBSQL;
import org.testng.annotations.Test;
import java.sql.SQLException;

// import static org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UseCaseTest {

    @Test
    public void testLoginCheck() throws SQLException{
        // Arrange
        DBSQL dbMock = mock(DBSQL.class);
        UseCase useCase = new UseCase();
        useCase.db = dbMock;
        // useCase.setDb(dbMock);

        String email = "idiotdum@hotmail.com";
        String correctPassword = "Ceri2200";
        String wrongPassword = "wrongpassword";

        // Stub the behavior of the mock
        when(dbMock.getAdminPassword(email)).thenReturn(correctPassword);

        // Act
        String resultCorrect = useCase.adminLoginCheck(email, correctPassword);
        String resultWrong = useCase.adminLoginCheck(email, wrongPassword);

        // Assert
        assertEquals("Correct", resultCorrect);
        assertEquals("Wrong password", resultWrong);

        // Verify the interaction with the mock
        verify(dbMock, times(2)).getAdminPassword(email);
    }
}
