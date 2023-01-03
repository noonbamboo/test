package com.noonbamboo.servlet;

import com.noonbamboo.entity.User;
import com.noonbamboo.service.UserService;
import com.noonbamboo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUpdateUser extends HttpServlet {

    private UserService service;

    public ShowUpdateUser() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //编码集
        req.setCharacterEncoding("utf-8");
        //获取数据
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        //调用service方法
        User user = this.service.selectUserById(id);
        if (user!=null){
            req.setAttribute("user",user);
        }else {
            req.setAttribute("errMessage","未找到用户");
        }
        req.getRequestDispatcher("showUpdateMaster.jsp").forward(req,resp);

    }
}
