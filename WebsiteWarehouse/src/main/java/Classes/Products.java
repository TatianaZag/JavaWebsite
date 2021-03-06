package Classes;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Products {

    public Products() {
    }

    public Products(String name_product, String type_prod, int count_prod, String unit_measure, Date date_prod, String storage_location, Suppliers id_supplier) {
        this.name_product = name_product;
        this.type_prod = type_prod;
        this.count_prod = count_prod;
        this.unit_measure = unit_measure;
        this.date_prod = date_prod;
        this.storage_location = storage_location;
        this.id_supplier = id_supplier;
    }

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getType_prod() {
        return type_prod;
    }

    public void setType_prod(String type_prod) {
        this.type_prod = type_prod;
    }

    public int getCount_prod() {
        return count_prod;
    }

    public void setCount_prod(int count_prod) {
        this.count_prod = count_prod;
    }

    public String getUnit_measure() {
        return unit_measure;
    }

    public void setUnit_measure(String unit_measure) {
        this.unit_measure = unit_measure;
    }

    public Date getDate_prod() {
        return date_prod;
    }

    public void setDate_prod(Date date_prod) {
        this.date_prod = date_prod;
    }
    
    public String getStorage_location() { return storage_location; }
    
    public void setStorage_location(String storage_location) { this.storage_location = storage_location; }

    @ManyToOne(targetEntity=Suppliers.class)
    @JoinColumn(nullable = false, name = "id_supplier")
    public Suppliers getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Suppliers id_supplier) {
        this.id_supplier = id_supplier;
    }

    private int id_product;
    private String name_product;
    private String type_prod;
    private int count_prod;
    private String unit_measure;
    private Date date_prod;
    private String storage_location;
    private Suppliers id_supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id_product == products.id_product && count_prod == products.count_prod && id_supplier.equals(id_supplier)
                && name_product.equals(products.name_product) && type_prod.equals(products.type_prod)
                && unit_measure.equals(products.unit_measure) && date_prod.equals(products.date_prod)
                && storage_location.equals(products.storage_location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_product, name_product, type_prod, count_prod, unit_measure, date_prod, storage_location, id_supplier);
    }
}
