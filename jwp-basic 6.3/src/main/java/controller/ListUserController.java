package controller;

import db.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListUserController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!UserSessionUtils.isLogined(request.getSession())) {
            response.sendRedirect("/users/loginForm");
            return;
        }

        request.setAttribute("users", DataBase.findAll());

        RequestDispatcher rd = request.getRequestDispatcher("/user/list.jsp");
        rd.forward(request, response);
    }
}
