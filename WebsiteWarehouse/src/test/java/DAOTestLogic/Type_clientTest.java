package DAOTestLogic;

import Classes.Type_client;
import Services.Type_clientServices;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Type_clientTest {
    private Type_clientServices typeService;
    private Type_client expectedType;

    @Test(alwaysRun = true)
    public void testReadByIdType() {
        Type_client realType = typeService.readTypeById(expectedType.getId_type());
        assertEquals(expectedType.getId_type(), realType.getId_type());
    }

    @AfterTest
    public void afterTest() {
        typeService.deleteType(expectedType);

    }
}
