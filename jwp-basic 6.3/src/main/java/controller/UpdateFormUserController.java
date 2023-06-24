package controller;

import core.mvc.Controller;
import db.DataBase;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormUserController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        User user = DataBase.findUserById(userId);
        if (!UserSessionUtils.isSameUser(request.getSession(), user)) {
            throw new IllegalStateException("다른 사람의 정보를 수정할 수 없습니다.");
        }
        request.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
