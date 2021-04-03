package Services;

import Classes.Type_client;
import DAO.Impl.Type_clientDAOImpl;
import DAO.Type_clientDAO;

public class Type_clientServices {
    private Type_clientDAO typeDao = new Type_clientDAOImpl();
    public void createType(Type_client type) {
        typeDao.create(type);
    }

    public void deleteType(Type_client type) {
        typeDao.delete(type);
    }

    public Type_client readTypeById(int id) {
        return typeDao.readById(id);
    }
}
