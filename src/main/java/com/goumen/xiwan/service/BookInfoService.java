package com.goumen.xiwan.service;

import com.goumen.xiwan.dao.BookInfoMapper;
import com.goumen.xiwan.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public BookInfo selectByPrimaryKey(Integer id){
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    public BookInfo selectByBookId(int bookId){
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }
}
