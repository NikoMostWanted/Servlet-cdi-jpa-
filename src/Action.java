import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by niko on 06/10/15.
 */
public class Action extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String login = req.getParameter("login");
        switch (action) {
            case "Create":
                req.setAttribute("login",login);
                req.getRequestDispatcher("create.jsp").forward(req, resp);
                break;
            case "Show":
                req.setAttribute("login",login);
                req.getRequestDispatcher("show.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
