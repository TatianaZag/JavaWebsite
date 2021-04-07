package Classes;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "deliveries")
public class Deliveries {
    private Object fetchType;

    public Deliveries() {
    }

    public Deliveries(Products id_product, Suppliers id_supplier, int count_prod, Date date_deliver, int storage_time) {
        this.id_product = id_product;
        this.id_supplier = id_supplier;
        this.count_prod = count_prod;
        this.date_deliver = date_deliver;
        this.storage_time = storage_time;
    }

    @Id
    @Column(name = "id_deliveries")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_deliveries() {
        return id_deliveries;
    }

    public void setId_deliveries(int id_deliveries) {
        this.id_deliveries = id_deliveries;
    }

    @ManyToOne(targetEntity=Products.class)
    @JoinColumn(name = "id_product")
    public Products getId_product() {
        return id_product;
    }

    public void setId_product(Products id_product) {
        this.id_product = id_product;
    }

    @ManyToOne(targetEntity=Suppliers.class)
    @JoinColumn(name = "id_supplier")
    public Suppliers getSupplier() {
        return id_supplier;
    }

    public void setSupplier(Suppliers id_supplier) {
        this.id_supplier = id_supplier;
    }

    public int getCount_prod() {
        return count_prod;
    }

    public void setCount_prod(int count_prod) {
        this.count_prod = count_prod;
    }

    public Date getDate_deliver() {
        return date_deliver;
    }

    public void setDate_deliver(Date date_deliver) {
        this.date_deliver = date_deliver;
    }

    public int getStorage_time() {
        return storage_time;
    }

    public void setStorage_time(int storage_time) {
        this.storage_time = storage_time;
    }

    private int id_deliveries;
    private Products id_product;
    private Suppliers id_supplier;
    private int count_prod;
    private Date date_deliver;
    private int storage_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliveries that = (Deliveries) o;
        return id_deliveries == that.id_deliveries && count_prod == that.count_prod && storage_time == that.storage_time
                && id_product.equals(that.id_product) && id_supplier.equals(that.id_supplier) && date_deliver.equals(that.date_deliver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_deliveries, id_product, id_supplier, count_prod, date_deliver, storage_time);
    }
}
