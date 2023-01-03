package com.noonbamboo.dao.impl;

import com.noonbamboo.dao.UserDao;
import com.noonbamboo.entity.User;
import com.noonbamboo.util.DataUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //定义全局变量
    DataUtil db = null;
    Statement statement = null;
    ResultSet rs = null;
    PreparedStatement preStatement = null;


    @Override
    public List<User> selectAll() {

        try {
            //新建list对象
            List<User> list = new ArrayList<User>();
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "select * from master";
            //创建statement对象
            statement = db.getStatement();
            //执行sql语句
            rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("money")));
            }
            return list;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭资源
            try {
                if (rs!=null)rs.close();
                if (statement!=null)statement.close();
                if (db!=null)db.closed();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    };

    @Override
    public User checkUserName(String userName) {
        try {
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "select * from master where username=?";
            //创建预编译
            preStatement = db.getPrepareStatement(sql);
            //给占位符赋值
            preStatement.setString(1,userName);
            //执行预编译，获取数据集
            rs = preStatement.executeQuery();
            if (rs.next()){
                return new User(rs.getString("username"),rs.getString("password"),rs.getInt("money"));
            };


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (rs!=null)rs.close();
                if (preStatement!=null)preStatement.close();
                if (db!=null)db.closed();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int addUser(String username,String password,int money) {

        try {
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "insert into master(username,password,money) values(?,?,?)";
            //创建预编译
            preStatement = db.getPrepareStatement(sql);
            //给占位符赋值
            preStatement.setString(1,username);
            preStatement.setString(2,password);
            preStatement.setInt(3,money);
            //执行预编译
            return preStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (preStatement!=null)preStatement.close();
                if (db!=null)db.closed();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        };
        return 0;
    }

    @Override
    public User selectUserById(int id) {
        try {
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "select * from master where id=?";
            //创建预编译
            preStatement = db.getPrepareStatement(sql);
            //给占位符赋值
            preStatement.setInt(1,id);
            //执行预编译，获取数据集
            rs = preStatement.executeQuery();
            if (rs.next()){
                return new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("money"));
            };

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (rs!=null)rs.close();
                if (preStatement!=null)preStatement.close();
                if (db!=null)db.closed();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int upDateUser(int id, String username, String password, int money) {
        try {
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "update master set username=?,password=?,money=? where id=?";
            //创建预编译
            preStatement = db.getPrepareStatement(sql);
            //给?赋值
            preStatement.setString(1,username);
            preStatement.setString(2,password);
            preStatement.setInt(3,money);
            preStatement.setInt(4,id);
            //执行预编译指令
            return preStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (preStatement!=null)preStatement.close();
                if (db!=null)db.closed();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int deleteUserById(int id) {
        try {
            //连接数据库
            db = new DataUtil();
            //创建sql语句
            String sql = "delete from master where id=?";
            //创建预编译
            preStatement = db.getPrepareStatement(sql);
            //给?赋值
            preStatement.setInt(1,id);
            //执行预编译
            return preStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
