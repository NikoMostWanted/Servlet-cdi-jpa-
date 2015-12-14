package Entity;

import javax.persistence.*;

/**
 * Created by niko on 05/11/15.
 */
@Entity
@Table(name = "cars")
public class Cars {
    private int id;
    private String cars;

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
    @Column(name = "cars", nullable = false, unique = true)
    public String getCars() {
        return cars;
    }

    public void setCars(String cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars1 = (Cars) o;

        if (id != cars1.id) return false;
        if (cars != null ? !cars.equals(cars1.cars) : cars1.cars != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }
}
