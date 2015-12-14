package Entity;

import javax.persistence.*;

/**
 * Created by niko on 05/11/15.
 */
@Entity
@Table(name = "namen")
public class Namen {
    private int id;
    private String namen;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namen", nullable = false, unique = true)
    public String getNamen() {
        return namen;
    }

    public void setNamen(String namen) {
        this.namen = namen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Namen namen1 = (Namen) o;

        if (id != namen1.id) return false;
        if (namen != null ? !namen.equals(namen1.namen) : namen1.namen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namen != null ? namen.hashCode() : 0);
        return result;
    }
}
