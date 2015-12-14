import com.sun.istack.internal.NotNull;


import javax.inject.Inject;
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
public class Registration extends HttpServlet {
    @Size(min=2,max=30)
    @NotNull
    @Pattern(regexp = "^[A-Za-zА-Яа-я]*$")
    private String name;
    @NotNull
    @Pattern(regexp = "^[A-Za-zА-Яа-я]*$")
    private String lastname;
    @NotNull
    @Size(min=2,max=30)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String login;
    @NotNull
    @Size(min=6,max=30)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String password;
    @Inject
    private NumberGenerator id_user;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id_user = new Generator();
        name = req.getParameter("name");
        lastname = req.getParameter("lastname");
        login = req.getParameter("login");
        password = req.getParameter("password");
        try {
            Connect.connect();
            if(Connect.registration(name, lastname, login, password)){
                req.setAttribute("login",login);
                req.setAttribute("id_user", Integer.toString(id_user.generateNumber()));
                req.getRequestDispatcher("menu.jsp").forward(req, resp);
            }
            else req.getRequestDispatcher("index.jsp").forward(req,resp);
            Connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
