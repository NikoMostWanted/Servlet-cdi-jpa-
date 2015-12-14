import javax.persistence.*;
import java.sql.*;
import java.util.List;

/**
 * Created by niko on 06/10/15.
 */
public class Connect {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static EntityManager entityManager /*= Persistence.createEntityManagerFactory("MyPersistence").createEntityManager()*/;
    public static Query query;

    /*public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/taxi", "root", "0000");
        statement = connection.createStatement();
    }*/

    public static void connect() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MyPersistence");
        entityManager = emfactory.createEntityManager();
    }

    public static void delete(int id) throws SQLException {
        statement.execute("DELETE FROM orders WHERE id="+id+"");
    }

    public static void update(String day,String month,String time, int id) throws SQLException {
        statement.execute("UPDATE orders SET days='"+day+"',months='"+month+"',times='"+time+"' WHERE id="+id+"");
    }

    public static void create(String car, String day, String month, String time, String login) throws ClassNotFoundException, SQLException, NullPointerException {
        int id_user = 0;
        int id_car = 0;
        resultSet = statement.executeQuery("SELECT id FROM cars WHERE cars ='" + car + "'");
        if (!resultSet.next()) {
            statement.execute("INSERT INTO cars VALUES(null,'" + car + "')");
        }
        resultSet = statement.executeQuery("SELECT id FROM users WHERE login = '"+login+"'");
        while (resultSet.next()) {
            id_user = resultSet.getInt("id");
        }
        resultSet = statement.executeQuery("SELECT id FROM cars WHERE cars = '"+car+"'");
        while (resultSet.next()){
            id_car = resultSet.getInt("id");
        }
        statement.execute("INSERT INTO orders VALUES(null," + id_user + "," + id_car + ",'" + day + "','" + month + "','" + time + "')");
    }

    public static ResultSet show(String login) throws ClassNotFoundException, SQLException {
        String query = "SELECT orders.id , namen.namen , lastnames.lastnames," +
                " cars.cars, orders.days , orders.months, orders.times" +
                " FROM cars INNER JOIN (orders INNER JOIN" +
                " (namen INNER JOIN (lastnames INNER JOIN users ON lastnames.id = users.id_lastname)" +
                " ON namen.id = users.id_name) ON users.id = orders.id_user)" +
                " ON cars.id = orders.id_car" +
                " WHERE users.login = '" + login + "'";
        resultSet = statement.executeQuery(query);
        return resultSet;
    }


    public static boolean registration(String name, String lastname, String login, String password) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        int id_name = 0;
        int id_lastname = 0;
        resultSet = statement.executeQuery("SELECT id FROM namen WHERE namen = '" + name + "'");
        if (!resultSet.next()) {
            statement.execute("INSERT INTO namen VALUES(null,'" + name + "')");
        }
        resultSet = statement.executeQuery("SELECT id FROM lastnames WHERE lastnames = '" + lastname + "'");
        if (!resultSet.next()) {
            statement.execute("INSERT INTO lastnames VALUES(null,'" + lastname + "')");
        }
        resultSet = statement.executeQuery("SELECT id FROM namen WHERE namen='" + name + "'");
        while (resultSet.next()) {
            id_name = resultSet.getInt("id");
        }
        resultSet = statement.executeQuery("SELECT id FROM lastnames WHERE lastnames='" + lastname + "'");
        while (resultSet.next()) {
            id_lastname = resultSet.getInt("id");
        }
        resultSet = statement.executeQuery("SELECT id FROM users WHERE login ='" + login + "'");
        if (resultSet.next()) {
            System.out.println("Такой логин уже есть!");
        } else {
            statement.execute("INSERT INTO users VALUES(null," + id_name + "," + id_lastname + ",'" + login + "','" + password + "')");
            flag = true;
        }
        return flag;
    }


    /*public static boolean authorization(String login, String password) throws ClassNotFoundException, SQLException, NullPointerException {
        boolean flag = false;
            resultSet = statement.executeQuery("SELECT id FROM users WHERE login ='" + login + "'");
            while (resultSet.next()) {
                resultSet = statement.executeQuery("SELECT password FROM users WHERE login='" + login + "'");
                while (resultSet.next()) {
                    String passwordToken = resultSet.getString("password");
                    if (password.contains(passwordToken)) {
                        flag = true;
                    }
                }
            }
        return flag;
    }*/

    public static boolean authorization(String login, String password) {
        boolean flag = false;
        query = entityManager.createQuery("select u.id from Users u where login = :login");
        query.setParameter("login",login);
        List<Integer> id = query.getResultList();
        for(Integer u : id) {
            query = entityManager.createQuery("select u1.password from Users u1 where login = :login");
            query.setParameter("login",login);
            List<String> pass = query.getResultList();
            for(String u1 : pass) {
                String passwordToken = u1;
                if(password.contains(passwordToken)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static void close() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }
}
