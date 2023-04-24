package com.spread.libserver.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.spread.libserver.doer.dofactory.Operation;
import com.spread.libserver.mapper.Vo.BookVo;
import com.spread.libserver.model.constant.AccountType;
import com.spread.libserver.model.dao.Book;
import com.spread.libserver.model.network.BoInfoResponse;
import com.spread.libserver.model.network.BookResponse;
import com.spread.libserver.model.network.CategoryResponse;
import com.spread.libserver.model.network.Response;

import jakarta.annotation.Resource;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * All operations that a manager can do.
 */
@RestController
@RequestMapping("managerop")
public class ManagerController {

//    @GetMapping("getallcat")
//    public CategoryResponse getAllCategoriesManager(){
//        return Operation.getAllCategories();
//    }

    @PostMapping("addcategory")
//    public Response addCategory(@RequestParam("name") String name,
////                                @RequestParam(value = "pname", required = false) String pname){
    public Response addCategory(@RequestBody String json){
        List list = Operation.jToV(json);
        String name = list.get(0).toString();
        String pname = list.get(1).toString();
        if(pname.equals("null"))
            pname = null;
        return Operation.addCategory(name, pname);
    }


    // TODO: Foreign key constraint, cannot delete category with books.
    @PostMapping("deletecategory")
    public Response deleteCategory(@RequestBody String json){
        List list = Operation.jToV(json);
        String name = list.get(0).toString();
        return Operation.deleteCategory(name);
    }

//    @RequestParam("isbn") String ISBN,
//    @RequestParam(value = "name", required = false) String name,
//    @RequestParam(value = "author", required = false) String author,
//    @RequestParam(value = "publisher", required = false) String publisher,
//    @RequestParam(value = "summary", required = false) String summary,
//    @RequestParam(value = "cover", required = false) String cover,
//    @RequestParam(value = "price", required = false) Float price,
//    @RequestParam(value = "stock", required = false) Integer stock,
//    @RequestParam(value = "category", required = false) String category
    @PostMapping("addbook")
    public Response addBook(@RequestBody String json){
        List list = Operation.jToV(json);
        String ISBN = list.get(0).toString();
        String name = list.get(1).toString();
        String author = list.get(2).toString();
        String publisher = list.get(3).toString();
        String summary = list.get(4).toString();
        String cover = list.get(5).toString();
        float price = Float.parseFloat(list.get(6).toString());
        int stock = Integer.parseInt(list.get(7).toString());
        String category = list.get(8).toString();
        return Operation.addBook(ISBN, name, author, publisher,
                summary, cover, price, stock, category);
    }

    @PostMapping("deletebook")
    public Response deleteBook(@RequestBody String json){
        List list = Operation.jToV(json);
        String ISBN = list.get(0).toString();
        return Operation.deleteBook(ISBN);
    }

    @PostMapping("getbook/bycategory")
    public BookResponse getBookByCategoryManager(@RequestBody String json){
        List list = Operation.jToV(json);
        String category = list.get(0).toString();
        return Operation.getBookByCategory(category);
    }

//    @PostMapping("getbook/byname")
//    public BookResponse getBookByNameManager(@RequestParam("name") String name){
//        return Operation.getBookByName(name);
//    }
    @PostMapping("getbook/byname")
    public BookResponse getBookByNameManager(@RequestBody String json){
        List list = Operation.jToV(json);
        String name = list.get(0).toString();
        return Operation.getBookByName(name);
    }

    @PostMapping("updatebook")
    public Response updateBook(@RequestBody String json){
        List list = Operation.jToV(json);
        String ISBN = list.get(0).toString();
        String name = list.get(1).toString();
        String author = list.get(2).toString();
        String publisher = list.get(3).toString();
        String summary = list.get(4).toString();
        String cover = list.get(5).toString();
        float price = Float.parseFloat(list.get(6).toString());
        int stock = Integer.parseInt(list.get(7).toString());
        String category = list.get(8).toString();
        Book newBook = new Book(ISBN,name,author,publisher,summary,cover,price,stock,category);
        return Operation.updateBook(newBook);
    }

//    @PostMapping("register")
//    public Response registerManager(@RequestParam("account") String acc,
//                                    @RequestParam("password") String pwd){
//        return Operation.register(acc, pwd, AccountType.MANAGER);
//    }


    @PostMapping("login")
    public Response loginManager(@RequestBody String json){
        List list = Operation.jToV(json);
        String acc = list.get(0).toString();
        String pwd = list.get(1).toString();
        return Operation.login(acc, pwd);
    }

    @PostMapping("changepassword")
    public Response changePasswordManger(@RequestBody String json){
        List list = Operation.jToV(json);
        String acc = list.get(0).toString();
        String targetAcc = list.get(1).toString();
        String newPassword = list.get(2).toString();
        return Operation.changePassword(acc, targetAcc, newPassword, AccountType.MANAGER);
    }


    /**
     * borrow a book
     */
//    @PostMapping("bookBorrowInfo")
//    public Response bookBorrow(@RequestParam("id") int id,
//                                   @RequestParam("name") String name,
//                                   @RequestParam("isbn") String isbn,
//                                   @RequestParam("date") int dates,
//                                   @RequestParam("account") String uName
//                                   ){
//        return Operation.borrowBook(id, name, isbn, dates, uName);
//    }
    @PostMapping("bookBorrow")
    public Response bookBorrow(@RequestBody String json){
        List list = Operation.jToV(json);
        int id = Integer.parseInt(list.get(0).toString());
        String name = list.get(1).toString();
        String isbn = list.get(2).toString();
        int dates = Integer.parseInt(list.get(3).toString());
        String uName = list.get(4).toString();
        return Operation.borrowBook(id, name, isbn, dates, uName);
    }


    @PostMapping("bookBorrowInfo")
    public BoInfoResponse boInfoResponse(@RequestBody String json){
        List list = Operation.jToV(json);
        int id =Integer.parseInt(list.get(0).toString());
        int page = Integer.parseInt(list.get(1).toString());
        int num = Integer.parseInt(list.get(2).toString());
        return Operation.booKBorrowInfo(id, page, num);
    }

    @Transactional
    @PostMapping("return")
    public Response returnBook(@RequestBody String json){
        List list = Operation.jToV(json);
        int bookId = Integer.parseInt(list.get(0).toString());
        Boolean isDamaged = Boolean.parseBoolean(list.get(1).toString());
        String account = list.get(2).toString();
        int borrowId = Integer.parseInt(list.get(3).toString());

        return Operation.returnBook(bookId, isDamaged, account, borrowId);
    }


}
