package com.yih.web;

import com.yih.pojo.User;
import com.yih.service.UserService;
import com.yih.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        if ("abcde".equalsIgnoreCase(code)) {

            if (userService.existsUsername(username)) {
                System.out.println("User[" + username + "] already exists!");


                req.setAttribute("msg", "User already exists！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                userService.registUser(new User(null, username, password, email));

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {

            req.setAttribute("msg", "Code is wrong！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("Verification code [" + code + "] is wrong");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
