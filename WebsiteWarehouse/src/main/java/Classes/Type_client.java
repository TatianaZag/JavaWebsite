package Classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_client")
public class Type_client {
    public Type_client() {

    }

    public Type_client(int id_type, String name_type) {
        this.id_type = id_type;
        this.name_type = name_type;
    }

    @Id
    @Column(name = "id_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    private int id_type;
    private String name_type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type_client that = (Type_client) o;
        return id_type == that.id_type && name_type.equals(that.name_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_type, name_type);
    }
}
