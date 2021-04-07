package Services;

import Classes.Type_client;
import DAO.Impl.Type_clientDAOImpl;
import DAO.Type_clientDAO;

public class Type_clientServices {
    private Type_clientDAO typeDao = new Type_clientDAOImpl();

    public Type_client readTypeById(int id) {
        return typeDao.readById(id);
    }
}
