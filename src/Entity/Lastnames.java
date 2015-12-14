package Entity;

import javax.persistence.*;

/**
 * Created by niko on 05/11/15.
 */
@Entity
@Table(name = "lastnames")
public class Lastnames {
    private int id;
    private String lastnames;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastnames", nullable = false, unique = true)
    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lastnames lastnames1 = (Lastnames) o;

        if (id != lastnames1.id) return false;
        if (lastnames != null ? !lastnames.equals(lastnames1.lastnames) : lastnames1.lastnames != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastnames != null ? lastnames.hashCode() : 0);
        return result;
    }
}
