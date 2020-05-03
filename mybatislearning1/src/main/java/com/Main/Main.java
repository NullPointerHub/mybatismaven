package com.Main;

import com.bean.Book;
import com.mapper.BookMapper;
import com.utils.Util;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Main {

    static Logger logger = Logger.getLogger(Object.class);



    @Test
    public void TestLog4j(){
        logger.info("Hello!");
    }




    public static void main(String[] args) {
        logger.info("Hello!");
        SqlSession sqlSession = Util.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = mapper.SelectAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void SelectById() {
        SqlSession sqlSession = Util.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = mapper.SelectById(2);
        System.out.println(book);
    }


    @Test
    public void InsertInto() {
        SqlSession sqlSession = Util.getSqlSession();
        Book book = new Book(5, "三国", "中国");
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int value = mapper.InsertInto(book);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(value);
    }


    @Test
    public void Update() {
        SqlSession sqlSession = Util.getSqlSession();
        Book book = new Book(5, "新三国", "中国");
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int value = mapper.Update(book);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(value);
    }

    @Test
    public void Delete() {
        SqlSession sqlSession = Util.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int value = mapper.Delete(5);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(value);
    }

}
