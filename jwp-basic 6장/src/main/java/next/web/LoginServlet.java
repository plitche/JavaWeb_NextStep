package next.web;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userId = req.getParameter("userId");
            String password = req.getParameter("password");
            log.debug("userId : {}", userId);

            User user = DataBase.findUserById(userId);

            HttpSession session = req.getSession();
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                resp.sendRedirect("/");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("/user/login_failed.jsp");
                rd.forward(req, resp);
            }
        } catch (NullPointerException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/user/login_failed.jsp");
            rd.forward(req, resp);
        }

    }
}
