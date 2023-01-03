package com.noonbamboo.servlet;

import com.noonbamboo.dao.UserDao;
import com.noonbamboo.entity.User;
import com.noonbamboo.service.UserService;
import com.noonbamboo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterControl extends HttpServlet {

    private UserService service;

    public RegisterControl() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("utf-8");
        //获取http数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        int money;
        try {
            money = Integer.parseInt(req.getParameter("money"));
        }catch (NumberFormatException e){
            money = 0;
        }

        //调用service方法
        int i = this.service.addUser(account,password,money);
        if (i==1){
            req.setAttribute("errMessage","用户名已存在");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }else if (i==2){
            resp.sendRedirect("UserServlet?page=showUserMessage");
        }else if (i==3){
            req.setAttribute("errMessage","注册失败");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }
}
