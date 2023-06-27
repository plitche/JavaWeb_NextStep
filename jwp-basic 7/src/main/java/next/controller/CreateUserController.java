package next.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import core.mvc.Controller;
import next.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/users/create")
public class CreateUserController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")
        );
        log.debug("User : {}", user);

        UserDao userDao = new UserDao();

        try {
            userDao.insert(user);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        resp.sendRedirect("/");

        /**
         * DataBase 대신 UserDao를 사용할 때 불편한 점은
         * UserDao의 모든 메소드가 SqlException을 throw하고 있기 떄문에
         * 컴파일 에러를 해결하기 위해 try/catch로 감싸줘야 한다는 것이다.
         */
    }
}
