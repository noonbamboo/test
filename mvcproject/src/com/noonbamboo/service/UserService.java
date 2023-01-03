package com.noonbamboo.service;

import com.noonbamboo.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    int addUser(String username,String password,int money);
    int login(String account,String password);
    int deleteUserById(int id);
    int updateUserById(int id,String username,String password,int money);
    User selectUserById(int id);
}
