import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by niko on 06/10/15.
 */
public class Operation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        switch (operation) {
            case "Authorization":
                req.getRequestDispatcher("authorization.jsp").forward(req,resp);
                break;
            case "Registration":
                req.getRequestDispatcher("registration.jsp").forward(req,resp);
                break;
            default:
                resp.getWriter().println("<html><body>Error 404</body></html>");
        }
    }

}
