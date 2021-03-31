package Classes;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customers {
    public Customers() {
    }

    public Customers(int id_customer, String name_customer, int id_type, String email, String number_phone, String address) {
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.id_type = id_type;
        this.email = email;
        this.number_phone = number_phone;
        this.address = address;
    }

    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int id_customer;
    private String name_customer;
    private int id_type;
    private String email;
    private String number_phone;
    private String address;
}
