package com.spread.libserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spread.libserver.model.dao.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Select("select * from book where (book.book_name = #{name} or book.book_isbn = #{isbn} or book.book_author = #{author}) ")
    List<Book> bookList (Page page,String name,String isbn, String author);
}
