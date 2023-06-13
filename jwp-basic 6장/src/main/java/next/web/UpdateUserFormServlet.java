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
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }
        req.setAttribute("user", DataBase.findUserById(userId));
        RequestDispatcher rd = req.getRequestDispatcher("/user/update.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        String msg = "";
        String url = "";

        User user = DataBase.findUserById(userId);
        if (password.equals(user.getPassword())) {
            log.debug("user : {}", user);

            user = new User(userId, password, name, email);
            DataBase.addUser(user);
            req.setAttribute("users", DataBase.findAll());

            msg = "개인정보 수정이 완료되었습니다.";
            url = "/user/list.jsp";
        } else {
            req.setAttribute("user", DataBase.findUserById(userId));
            msg = "비밀번호가 일치하지 않습니다.";
            url = "/user/update.jsp";
        }

        req.setAttribute("message", msg);
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
