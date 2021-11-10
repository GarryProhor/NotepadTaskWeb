package by.prohor.controllers;

import by.prohor.constants.AppConstant;
import by.prohor.model.entities.User;
import by.prohor.model.exception.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AuthorizationController", value = AppConstant.AUTHORIZATION)
public class AuthorizationController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        try {
            User user = userService.get(login, password);

            if(Objects.nonNull(user)){
                request.setAttribute(AppConstant.USER_ATTR, user);
                jump(request, response, AppConstant.HOME_JSP);
            }else{
                jumpMessage(request, response, AppConstant.LOGIN_JSP, AppConstant.INVALID_AUTHORIZATION_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.LOGIN_JSP, e.getMessage());
        }
    }
}
