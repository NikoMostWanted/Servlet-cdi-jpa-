import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by niko on 06/10/15.
 */
public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String car = req.getParameter("car");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String time = req.getParameter("time");
        String login = req.getParameter("login");
        try {
            Connect.connect();
            Connect.create(car, day, month, time, login);
            Connect.close();
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
