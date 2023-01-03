package com.noonbamboo.dao;

import com.noonbamboo.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    //查询所有方法
    List<User> selectAll();
    //查询用户名方法
    User checkUserName(String userName);
    //增加用户方法
    int addUser(String username,String password,int money);
    //根据id查询用户方法
    User selectUserById(int id);
    //修改用户信息
    int upDateUser(int id,String username,String password,int money);
    //根据id删除用户信息
    int deleteUserById(int id);
}
