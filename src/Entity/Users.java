package Entity;

import javax.persistence.*;

/**
 * Created by niko on 05/11/15.
 */
@Entity
@Table(name = "users")
public class Users {
    private int id;
    private int idName;
    private int idLastname;
    private String login;
    private String password;

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
    @Column(name = "id_name", nullable = false)
    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    @Basic
    @Column(name = "id_lastname", nullable = false)
    public int getIdLastname() {
        return idLastname;
    }

    public void setIdLastname(int idLastname) {
        this.idLastname = idLastname;
    }

    @Basic
    @Column(name = "login", nullable = false, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (idName != users.idName) return false;
        if (idLastname != users.idLastname) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idName;
        result = 31 * result + idLastname;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
