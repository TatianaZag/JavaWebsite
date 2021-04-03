import Classes.Type_client;
import Services.Type_clientServices;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Type_clientTest {
    private Type_clientServices typeService;
    private Type_client expectedType;

    @Before
    public void setUp() {
        typeService = new Type_clientServices();
        expectedType = new Type_client(1,
                "физ.лицо"
        );
        typeService.createType(expectedType);
    }

    @Test
    public void testCreateType() {
        Type_client realType = typeService.readTypeById(expectedType.getId_type());
        assertEquals(expectedType, realType);
    }

    @Test
    public void testDeleteType() {
        Type_client realType = typeService.readTypeById(expectedType.getId_type());
        assertEquals(expectedType, realType);

        typeService.deleteType(expectedType);
        realType = typeService.readTypeById(expectedType.getId_type());
        assertEquals(expectedType, realType);
    }

    @Test
    public void testReadByIdType() {
        Type_client realType = typeService.readTypeById(expectedType.getId_type());
        assertEquals(expectedType.getId_type(), realType.getId_type());
    }

    @After
    public void afterTest() {
        typeService.deleteType(expectedType);

    }
}
