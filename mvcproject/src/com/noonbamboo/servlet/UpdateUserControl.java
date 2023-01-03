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

public class UpdateUserControl extends HttpServlet {

    private UserService service;

    public UpdateUserControl() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码集
        req.getRequestDispatcher("utf-8");
        //获取数据
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        System.out.println(id);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int money;
        try {
            money = Integer.parseInt(req.getParameter("money"));
        }catch (NumberFormatException e){
            money = 0;
        }
        //调用service方法
        int i = this.service.updateUserById(id,username,password,money);
        if (i==0){
            req.setAttribute("errMessage","修改失败");
            User user = this.service.selectUserById(id);
            req.setAttribute("user",user);
            req.getRequestDispatcher("showUpdateMaster.jsp").forward(req,resp);
        }else if (i==1){
            resp.sendRedirect("UserServlet?page=showUserMessage");
        }else {
            req.setAttribute("errMessage","用户名已存在");
            User user = this.service.selectUserById(id);
            req.setAttribute("user",user);
            req.getRequestDispatcher("showUpdateMaster.jsp").forward(req,resp);
        }

    }
}
