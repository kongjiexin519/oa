package com.oa.service;
import com.oa.dao.RbacDao;
import com.oa.dao.UserDao;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.exception.BusinessException;
import com.oa.utils.MD5Utils;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    private RbacDao rbacDao = new RbacDao();

    public User checkLogin(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new BusinessException("L001", "用户名不存在");
        }

        String md5 = MD5Utils.md5Digest(password, user.getSalt());
        if (!user.getPassword().equals(md5)) {
            throw new BusinessException("L002", "密码错误");
        }
        return user;
    }

    public List<Node> selectNodeByUserId(Long userId){
        List<Node> list = rbacDao.selectNodeByUserId(userId);
        System.out.println(list);
        return list;
    }
}
