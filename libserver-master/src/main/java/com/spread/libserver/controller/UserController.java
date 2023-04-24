package com.spread.libserver.controller;

import com.spread.libserver.doer.dofactory.Operation;
import com.spread.libserver.model.constant.AccountType;
import com.spread.libserver.model.network.BookResponse;
import com.spread.libserver.model.network.CategoryResponse;
import com.spread.libserver.model.network.LoginResponse;
import com.spread.libserver.model.network.Response;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * All operations that a user can do.
 */
@RestController
public class UserController {

    @PostMapping("userop/register")
    public Response registerUser(@RequestBody String json){
        List list = Operation.jToV(json);
        String acc = list.get(0).toString();
        String pwd = list.get(1).toString();
        return Operation.register(acc, pwd, AccountType.USER);
    }

//    @GetMapping("userop/login")
//    public Response loginUser(@RequestParam("account") String acc,
//                              @RequestParam("password") String pwd){
//        return Operation.login(acc, pwd);
//    }



//    @GetMapping("userop/getallcategory")
//    public CategoryResponse getAllCategoriesUser(){
//        return Operation.getAllCategories();
//    }

    @PostMapping("userop/getbook/bycategory")
    public BookResponse getBookByCategoryUser(@RequestBody String json){
        List list = Operation.jToV(json);
        String category = list.get(0).toString();
        return Operation.getBookByCategory(category);
    }

    @PostMapping("userop/getbook/byname")
    public BookResponse getBookByNameUser(@RequestBody String json){
        List list = Operation.jToV(json);
        String name = list.get(0).toString();
        String isbn = list.get(1).toString();
        String author = list.get(2).toString();
        int page = Integer.parseInt(list.get(3).toString());
        boolean ready = Boolean.parseBoolean(list.get(4).toString());
        return Operation.getBookByName(name,isbn,author,page,ready);
    }

//    @Transactional
//    @GetMapping("userop/borrow")
//    public Response borrowBook(@RequestParam("bookid") int id,
//                               @RequestParam("duration") int duration,
//                               @RequestParam("fine") float fine,
//                               @RequestParam("account") String account){
//        return Operation.borrowBook(id, duration, fine, account);
//    }

//    @Transactional
//    @PostMapping("userop/return")
//    public Response returnBook(@RequestBody String json){
//        List list = Operation.jToV(json);
//        int bookId = Integer.parseInt(list.get(0).toString());
//        Boolean isDamaged = Boolean.parseBoolean(list.get(1).toString());
//        String account = list.get(2).toString();
//        int borrowId = Integer.parseInt(list.get(3).toString());
//
//        return Operation.returnBook(bookId, isDamaged, account, borrowId);
//    }

    //**********************************************************************************************


    @PostMapping("userop/login")
    public LoginResponse loginUser(@RequestParam("account") String acc,
                                            @RequestParam("password") String pwd,
                                            @RequestParam("type") int type
                             ){
        return Operation.login(acc, pwd);
    }

    @PostMapping("userop/changepassword")
    public Response changePasswordUser(@RequestParam("account") String acc,
                                       @RequestParam("oldpswd") String oldpassword,
                                       @RequestParam("newpswd") String newPassword){
        return Operation.changePassword(acc, oldpassword, newPassword, AccountType.USER);
    }
}
