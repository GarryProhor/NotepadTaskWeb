package by.prohor.controllers;

import by.prohor.constants.AppConstant;
import by.prohor.model.services.interfaces.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AbstractController", value = "/AbstractController")
public abstract class AbstractController extends HttpServlet {
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        String dao = getServletContext().getInitParameter(AppConstant.DAO_IMPL);
        userService = new UserService(dao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
       request.getRequestDispatcher(url).forward(request, response);
    }

    protected void jumpMessage(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(AppConstant.MESSAGE_ATTR, message);
        jump(request, response, url);
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(url);
    }
}
