package com.oa.dao;

import com.oa.entity.User;
import com.oa.utils.MybatisUtils;

public class UserDao {
    public User selectByUsername(String username){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername",username));
        return user;
    }
}
