import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by niko on 08/10/15.
 */
public class DeleteAndUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("op");
        int id = Integer.parseInt(req.getParameter("val"));
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String time = req.getParameter("time");
        switch (operation) {
            case "Delete":
                try {
                    Connect.connect();
                    Connect.delete(id);
                    Connect.close();
                    resp.getWriter().print("<html><body>Delete success!!!</body></html>");
                }/*catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }*/
                catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Update":
                try {
                    Connect.connect();
                    Connect.update(day, month, time, id);
                    Connect.close();
                    resp.getWriter().print("<html><body>Update success!!!</body></html>");
                } /*catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }*/
                catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                resp.getWriter().print("<html><body>Loool!!!</body></html>");
        }
    }
}
