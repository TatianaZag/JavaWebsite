package Classes;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "provision")
public class Provision {
    public Provision() {
    }

    public Provision(int id_provision, int id_product, int id_customer, int count_prod, Date date_prov, String status) {
        this.id_provision = id_provision;
        this.id_product = id_product;
        this.id_customer = id_customer;
        this.count_prod = count_prod;
        this.date_prov = date_prov;
        this.status = status;
    }

    @Id
    @Column(name = "id_provision")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_provision() {
        return id_provision;
    }

    public void setId_provision(int id_provision) {
        this.id_provision = id_provision;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getCount_prod() {
        return count_prod;
    }

    public void setCount_prod(int count_prod) {
        this.count_prod = count_prod;
    }

    public Date getDate_prov() {
        return date_prov;
    }

    public void setDate_prov(Date date_prov) {
        this.date_prov = date_prov;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int id_provision;
    private int id_product;
    private int id_customer;
    private int count_prod;
    private Date date_prov;
    private String status;
}
