import com.sun.istack.internal.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by niko on 06/10/15.
 */
public class Authorization extends HttpServlet {
    @NotNull
    @Size(min=2,max=30)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String login;
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    @NotNull
    @Size(min=6,max=50)
    private String password;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
             login = req.getParameter("login");
             password = req.getParameter("password");
            Connect.connect();
            if(Connect.authorization(login,password)){
                Connect.close();
                req.setAttribute("login",login);
                req.getRequestDispatcher("menu.jsp").forward(req,resp);
            }
            else {
                Connect.close();
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
        /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
