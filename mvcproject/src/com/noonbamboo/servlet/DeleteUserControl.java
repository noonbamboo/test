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

public class DeleteUserControl extends HttpServlet {

    private UserService service;

    public DeleteUserControl() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码集
        req.getRequestDispatcher("utf-8");
        //获取request信息
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        //调用service方法
        int i = this.service.deleteUserById(id);
        if (i>0){
            resp.sendRedirect("UserServlet?page=showUserMessage");
        }else {
            req.setAttribute("errMessage","删除失败，请选择正确id");
            req.getRequestDispatcher("showUserMessage.jsp").forward(req,resp);
        }

    }
}
