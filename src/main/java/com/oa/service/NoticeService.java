package com.oa.service;

import com.oa.dao.NoticeDao;
import com.oa.entity.Notice;
import com.oa.utils.MybatisUtils;

import java.util.List;

public class NoticeService {
    public List<Notice> getNoticeList(Long receiverId){
        return (List) MybatisUtils.executeQuery(sqlSession -> {
            NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
            return noticeDao.selectByReceiverId(receiverId);
        });
    }
}
