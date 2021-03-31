package Classes;

import javax.persistence.*;;

@Entity
@Table(name = "suppliers")
public class Suppliers {
    public Suppliers(int id_supplier, String name_supplier, int id_type, String email, String number_phone, String address) {
        this.id_supplier = id_supplier;
        this.name_supplier = name_supplier;
        this.id_type = id_type;
        this.email = email;
        this.number_phone = number_phone;
        this.address = address;
    }

    public Suppliers() {
    }

    @Id
    @Column(name = "id_supplier")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getName_supplier() {
        return name_supplier;
    }

    public void setName_supplier(String name_supplier) {
        this.name_supplier = name_supplier;
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

    private int id_supplier;
    private String name_supplier;
    private int id_type;
    private String email;
    private String number_phone;
    private String address;
}
