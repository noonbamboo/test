package com.noonbamboo.service.impl;

import com.noonbamboo.dao.UserDao;
import com.noonbamboo.dao.impl.UserDaoImpl;
import com.noonbamboo.entity.User;
import com.noonbamboo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao;
    public UserServiceImpl(){
        this.dao = new UserDaoImpl();
    };

    @Override
    public List<User> selectAll() {
        return this.dao.selectAll();
    };

    @Override
    public int addUser(String username, String password, int money) {
        if (this.dao.checkUserName(username)!=null){
            //用户名已存在，返回1
            return 1;
        }else if (this.dao.addUser(username, password, money)>0){
            //操作成功，返回2
            return 2;
        }else {
            //操作失败，返回3
            return 3;
        }

    };

    @Override
    public int login(String account, String password) {
        User user = this.dao.checkUserName(account);
        if (user!=null){
            if (user.getPassword().equals(password)){
                //登录成功
                return 1;
            }else {
                //密码或账号错误
                return 2;
            }
        }else {
            //用户名不存在
            return 0;
        }
    };

    @Override
    public int deleteUserById(int id) {
        return this.dao.deleteUserById(id);
    };

    @Override
    public int updateUserById(int id,String username,String password,int money) {
        User userupdating = this.dao.selectUserById(id);
        User user = this.dao.checkUserName(username);
        System.out.println(user);
        if (user!=null && !user.getName().equals(userupdating.getName())){
            //用户名存在
            return 2;
        }else{
            return this.dao.upDateUser(id, username, password, money);
        }
    }

    @Override
    public User selectUserById(int id) {
        return this.dao.selectUserById(id);
    }
}
