import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by niko on 06/10/15.
 */
public class Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        try {
            Connect.connect();
            ResultSet resultSet = Connect.show(login);
            while (resultSet.next()) {
                id.add(resultSet.getInt("orders.id"));
                data.add(resultSet.getString("namen.namen"));
                data.add(resultSet.getString("lastnames.lastnames"));
                data.add(resultSet.getString("cars.cars"));
                data.add(resultSet.getString("orders.days"));
                data.add(resultSet.getString("orders.months"));
                data.add(resultSet.getString("orders.times"));
            }
            resultSet.close();
            req.setAttribute("data", data);
            req.setAttribute("id", id);
            Connect.close();
            req.getRequestDispatcher("result.jsp").forward(req, resp);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
