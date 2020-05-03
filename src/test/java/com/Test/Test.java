package com.Test;

import com.bean.Book;
import com.mapper.BookMapper;
import com.utils.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class Test {
    @org.junit.Test
    public void Test() {
        SqlSession sqlSession = Util.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = mapper.SelectAll();
        for (Book book:books) {
            System.out.println(book);
        }
    }
}
