package com.spread.libserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spread.libserver.mapper.Vo.BookVo;
import com.spread.libserver.model.dao.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

public interface BorrowMapper extends BaseMapper<Borrow> {
//    @Select("select b.book_isbn, b.book_name, b.book_author, bo.borrow_account, bo.borrow_time , bo.borrow_duration , bo.borrow_is_over_time " +
//            "from book b , borrow bo where b.book_id = bo.borrow_book_id and bo.borrow_book_id = #{id}")
    //List<BookVo> bookList (Page page,Integer id);
    @Select("select b.book_isbn, b.book_name, b.book_author, bo.borrow_account, bo.borrow_time , bo.borrow_duration , bo.borrow_is_over_time " +
            "from book b , borrow bo where b.book_id = bo.borrow_book_id ")
    List<BookVo> bookList (Page page);
    @Select("select b.book_isbn, b.book_name, b.book_author, bo.borrow_account, bo.borrow_time , bo.borrow_duration , bo.borrow_is_over_time " +
            "from book b , borrow bo where b.book_id = bo.borrow_book_id and b.book_name = #{name}")
    List<BookVo> bookList1 (Page page,String name);
}

