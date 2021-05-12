package Services;

import Classes.Products;
import DAO.Impl.ProductsDAOImpl;
import DAO.ProductsDAO;

import java.sql.Date;
import java.util.List;

public class ProductsServices {
    private ProductsDAO productDAO = new ProductsDAOImpl();
    private Products product;

    public ProductsServices() {
    }

    public void createProduct(Products product) {
        productDAO.create(product);
    }

    public void updateProduct(Products product) {
        productDAO.update(product);
    }

    public void deleteProduct(Products product) {
        productDAO.delete(product);
    }

    public Products readProductById(int id) {
        return productDAO.readById(id);
    }

    public List<Products> readProductByStorage_location(String num_storage) {
        return productDAO.readByStorageLocation(num_storage);
    }

    public  List<Products> readProductByType(String type) {
        return productDAO.readByTypeProduct(type);
    }

    public List<Products> readProductByDate(Date date) {
        return productDAO.readByDate(date);
    }

    public List<Products> readProductAll() {
        return productDAO.readAllProduct();
    }
}
