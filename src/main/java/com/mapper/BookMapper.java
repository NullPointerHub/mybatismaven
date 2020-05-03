package com.mapper;

import com.bean.Book;

import java.util.List;

public interface BookMapper {
    List<Book> SelectAll();
    Book SelectById(int Id);
    int InsertInto(Book book);
    int Update(Book book);
    int Delete(int Id);
}
