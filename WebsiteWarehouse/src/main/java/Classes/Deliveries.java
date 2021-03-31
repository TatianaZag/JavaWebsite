package Classes;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "deliveries")
public class Deliveries {
    public Deliveries() {
    }

    public Deliveries(int id_deliveries, int id_product, int supplier, int count_prod, Date date_deliver, int storage_time) {
        this.id_deliveries = id_deliveries;
        this.id_product = id_product;
        this.supplier = supplier;
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

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
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
    private int id_product;
    private int supplier;
    private int count_prod;
    private Date date_deliver;
    private int storage_time;
}
