package com.noonbamboo.servlet;

import com.noonbamboo.entity.User;
import com.noonbamboo.service.UserService;
import com.noonbamboo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginControl extends HttpServlet {

    private UserService service;

    public LoginControl() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码集
        req.setCharacterEncoding("utf-8");
        //获取数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //调用service方法
        int i = this.service.login(account,password);
        if (i==0){
            //用户名不存在
            req.setAttribute("errMessage","用户名不存在！！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else if (i==1){
            //登录成功,跳转到用户信息界面
            HttpSession session = req.getSession();
            session.setAttribute("account",account);
            resp.sendRedirect("UserServlet?page=showUserMessage");
        }else {
            //登录失败
            req.setAttribute("errMessage","账号或密码错误！！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
