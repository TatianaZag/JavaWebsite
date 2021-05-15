package DAO;
import Classes.Products;

import java.sql.Date;
import java.util.List;

public interface ProductsDAO {
    void create(Products product);
    void update(Products product);
    void delete(Products product);
    Products readById(int id);
    List<Products> readByStorageLocation(String num_storage);
    List<Products> readByTypeProduct(String type);
    List<Products> readByDate(Date date);
    List<Products> readAllProduct();
    List<Products> findProductByIdSupplier(int id);
    List<Products> findProductByType(String type);
    List<Products> findProductByDateAfter(Date date);
    List<Products> findProductByDateBefore(Date date);
}
