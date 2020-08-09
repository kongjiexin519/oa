package com.oa.service;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.utils.MybatisUtils;

public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department) MybatisUtils.executeQuery(sqlSession -> {
            DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
            return departmentDao.selectById(departmentId);
        });
    }
}
