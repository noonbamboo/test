package com.noonbamboo.servlet;

import com.noonbamboo.entity.User;
import com.noonbamboo.service.UserService;
import com.noonbamboo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService service;

    public UserServlet() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取post信息
        String page = req.getParameter("page");
        String state = req.getParameter("state");
        //判断page信息
        switch (page) {
            case "showUserMessage":
                //调用service方法获取数据
                List<User> userList = this.service.selectAll();
                //将数据保存到request作用域中
                req.setAttribute("allUser", userList);
                req.getRequestDispatcher("showUserMessage.jsp").forward(req, resp);
                break;
            case "register":
                resp.sendRedirect("register.jsp");
                break;
            case "login":
                if ("nil".equals(state)){
                    req.setAttribute("errMessage","您还没有登录，请先登录！！");
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                }else {
                    resp.sendRedirect("login.jsp");
                }

                break;
        }


    }
}
