package DAOTestLogic;

import Classes.Type_client;
import Services.Type_clientServices;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Type_clientTest {
    @Test(alwaysRun = true)
    public void testReadByIdType() {
        Type_clientServices typeServices = new Type_clientServices();

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Type_client> query = session.createQuery("FROM Type_client WHERE id_type = 1", Type_client.class);
        Type_client expectedName = query.getSingleResult();

        Type_client realName = typeServices.readTypeById(expectedName.getId_type());
        assertEquals(expectedName.getName_type(), realName.getName_type());
    }
}
