package DAO;
import Classes.Type_client;

public interface Type_clientDAO {
    void create(Type_client type);
    void delete(Type_client type);
    Type_client readById(int id);
}
