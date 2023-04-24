package com.spread.libserver.doer.dofactory;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spread.libserver.mapper.*;
import com.spread.libserver.mapper.Vo.BookVo;
import com.spread.libserver.model.constant.AccountType;
import com.spread.libserver.model.constant.Op;
import com.spread.libserver.model.dao.*;
import com.spread.libserver.model.network.*;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class Operation {


    private static CategoryMapper categoryMapper;
    private static BookMapper bookMapper;
    private static AccountMapper accountMapper;
    private static BorrowMapper borrowMapper;
    private static TokenMapper tokenMapper;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void setAllMapper(CategoryMapper cm, BookMapper bm, AccountMapper am, BorrowMapper brm, TokenMapper tm){
        categoryMapper = cm;
        bookMapper = bm;
        accountMapper = am;
        borrowMapper = brm;
        tokenMapper = tm;
    }

    /**
     * Register functionality, #type is the type of the account:
     *      1 -> manager;
     *      2 -> user.
     * @param acc account name
     * @param pwd account password
     * @return A response to the client, telling whether it is successful or not.
     */
    public static Response register(String acc, String pwd,
                                    int type){
        /*
             Select in mysql with the account name passed by client(acc).
             If it does exist, return a failure.
         */
        Response res = new Response(false);
        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Account::getName, acc);

//        if(type == AccountType.MANAGER) res.setOp(Op.REGISTER_MANAGER);
//        else if(type == AccountType.USER) res.setOp(Op.REGISTER_USER);
        res.setOp(Op.REGISTER_USER);


        if(null == accountMapper.selectOne(lqw)){ // no result, means everything ok.
            accountMapper.insert(new Account(acc, pwd, type));
            /*
                After insertion, I sho
                - uld ensure that the account ought to be
                existed in mysql.
             */
            if(null != accountMapper.selectOne(lqw)){
                res.setStatus(true);
                res.setMsg(Msg.Success.Register());
            }else{
                res.setMsg(Msg.Fail.ISE());
            }
        }else{
            res.setMsg(Msg.Fail.AccountRegistered(acc));
        }
        return res;
    }

    /**
     * Login functionality. Both user and manager use this inface to perform login.
     * @param acc account name
     * @param pwd password
     * @return If account name does not exist, or password is incorrect,
     *         we'll return a failure; return ok when account name and
     *         password is both correct.
     */
//    public static Response login(String acc, String pwd){
//        Response res = new Response(false, Op.LOGIN);
//        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(Account::getName, acc);
//        Account a = accountMapper.selectOne(lqw);
//        if(a != null){
//            if(pwd.equals(a.getPassword())){
//                res.setStatus(true);
//                res.setMsg(Msg.Success.Login());
//            }else{
//                res.setMsg(Msg.Fail.WrongPassword(acc));
//            }
//        }else{  // Account doesn't exist.
//            res.setMsg(Msg.Fail.AccountNotExist(acc));
//        }
//        return res;
//    }
    public static LoginResponse login(String acc, String pwd){
        LoginResponse res = new LoginResponse(false, Op.LOGIN);
        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Account::getName, acc);
        Account a = accountMapper.selectOne(lqw);
        int type = a.getType();
        if(a != null){
            if(pwd.equals(a.getPassword())){
                res.setToken(UUID.randomUUID().toString());
                LambdaQueryWrapper<Token> tqw = new LambdaQueryWrapper<>();
                tqw.eq(Token::getAccount, acc);
                Token token = tokenMapper.selectOne(tqw);
                if(token != null){
                    res.setToken(token.getToken_info());
                }else {
                    String newToken = UUID.randomUUID().toString();
                    tokenMapper.insert(new Token(acc,newToken));
                    res.setToken(newToken);
                }
                res.setStatus(true);
                res.setUserType(type);
                res.setMsg(Msg.Success.Login(type));
            }else{
                res.setMsg(Msg.Fail.WrongPassword(acc));
            }
        }else{  // Account doesn't exist.
            res.setMsg(Msg.Fail.AccountNotExist(acc));
        }
        return res;
    }

//    public static Response changePassword(String acc,
//                                          String targetAcc,
//                                          String newPassword,
//                                          int type){
//        Response res = new Response(false, Op.CHANGE_PSWD);
//        LambdaQueryWrapper<Account> lTarget = new LambdaQueryWrapper<>();
//        LambdaQueryWrapper<Account> lSelf = new LambdaQueryWrapper<>();
//        lTarget.eq(Account::getName, targetAcc);
//        lSelf.eq(Account::getName, acc);
//        Account target = accountMapper.selectOne(lTarget);
//        Account self = accountMapper.selectOne(lSelf);
//
//        if(target == null){
//            res.setMsg(Msg.Fail.TargetNotExist(targetAcc));
//            return res;
//        }
//        if(self == null){
//            res.setMsg(Msg.Fail.AccountNotExist(acc));
//            return res;
//        }
//
//        switch(type){
//            case AccountType.MANAGER -> {
//                if(acc.equals(targetAcc)){ // change own
//                    performChange(newPassword, res, lTarget, target);
//                }else{  // change other's
//                    // can't change other manager's password.
//                    if(target.getType() == AccountType.MANAGER) res.setMsg(Msg.Fail.ChangeOtherManager());
//                    else performChange(newPassword, res, lTarget, target);
//                }
//            }
//            case AccountType.USER -> {
//                if(!acc.equals(targetAcc)){ // You can only change the password of your own.
//                    res.setMsg(Msg.Fail.ChangeOther());
//                    return res;
//                }
//                performChange(newPassword, res, lTarget, target);
//            }
//        }
//
//        return res;
//    }

    public static Response changePassword(String acc,
                                          String targetAcc,
                                          String newPassword,
                                          int type){
        Response res = new Response(false, Op.CHANGE_PSWD);
        LambdaQueryWrapper<Account> lTarget = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Account> lSelf = new LambdaQueryWrapper<>();
        lSelf.eq(Account::getName, acc);
//        lTarget.eq(Account::getName, targetAcc);
//        Account target = accountMapper.selectOne(lTarget);
        Account self = accountMapper.selectOne(lSelf);
        if(self == null){
            res.setMsg(Msg.Fail.AccountNotExist(acc));
            return res;
        }
        switch(type){
            case AccountType.MANAGER -> {
                lTarget.eq(Account::getName, targetAcc);
                Account target = accountMapper.selectOne(lTarget);
                if(target == null){
                    res.setMsg(Msg.Fail.TargetNotExist(targetAcc));
                    return res;
                }
                if(acc.equals(targetAcc)){ // change own
                    performChange(newPassword, res, lTarget, target);
                }else{  // change other's
                    // can't change other manager's password.
                    if(target.getType() == AccountType.MANAGER) res.setMsg(Msg.Fail.ChangeOtherManager());
                    else performChange(newPassword, res, lTarget, target);
                }
            }
            case AccountType.USER -> {
//                if(!acc.equals(targetAcc)){ // You can only change the password of your own.
//                    res.setMsg(Msg.Fail.ChangeOther());
//                    return res;
//                }
                //判读输入的旧密码和数据库中的是否一致
                LambdaQueryWrapper<Account> qw = new LambdaQueryWrapper<>();
                qw.eq(Account::getName, acc);
                if(targetAcc.equals(accountMapper.selectOne(qw).getPassword())){
//                    performChange(newPassword, res, lTarget, target);
                    performChange(newPassword, res, lSelf, self);
                }else{
                    res.setMsg(Msg.Fail.wrongOldPswd());
                    System.out.println(accountMapper.selectOne(qw));
                    return res;
                }

            }
        }

        return res;
    }

    public static CategoryResponse getAllCategories(int page, int num){
        IPage iPage = new Page(page,num);
        List<Category> list = categoryMapper.selectPage(iPage,null).getRecords();
        CategoryResponse res = new CategoryResponse(false, Op.GET_ALL_CATEGORIES);
        if(!list.isEmpty()){
            res.setCategories(list);
            res.setStatus(true);
            res.setMsg(Msg.Success.GetAllCategories());
        }else{
            res.setMsg(Msg.Fail.NoCategory());
        }
        return res;
    }

    /**
     * Add a category
     * @param name Category name
     * @param pname Name of the category's parent.It may be null, if it is a top-level one.
     * @return Whether add successfully or not.
     */
    public static Response addCategory(String name, String pname){
        Response res = new Response(false, Op.ADD_CATEGORY);
        Category c = new Category(name, true);
        LambdaQueryWrapper<Category> l = new LambdaQueryWrapper<>();
        l.eq(Category::getName, name);

        // At first, I should ensure there's no category with the name.
        if(!categoryMapper.selectList(l).isEmpty()){ // not empty, means that you shouldn't insert
            res.setMsg(Msg.Fail.CategoryExisted(name));
            return res;
        }

        // Before insertion, I should know the id of it's parent, pid.
        // If pname is null, it means the category to be added is the most top-level one.
        if(null != pname){
            LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<>();
            lqw.eq(Category::getName, pname);
            Category parent = categoryMapper.selectOne(lqw);
            if(parent != null){
                c.setPid(parent.getId());
                if(parent.isDeepest()){
                    parent.setDeepest(false);
                    categoryMapper.updateById(parent);
                }
            }else{
                res.setMsg(Msg.Fail.NoCategory(pname));
                return res;
            }
        }
        if(c.getPid() == 0)
            c.setDeepest(false);
        categoryMapper.insert(c);

        // After insertion, I should ensure that it has been done.

        if(categoryMapper.selectOne(l) != null){ // exist, insert successfully
            res.setStatus(true);
            res.setMsg(Msg.Success.AddCategory(name));
        }else{
            res.setMsg(Msg.Fail.ISE());
        }
        return res;
    }

    public static Response deleteCategory(String name){
        Response res = new Response(false, Op.DELETE_CATEGORY);
        LambdaQueryWrapper<Category> l = new LambdaQueryWrapper<>();
        l.eq(Category::getName, name);
        Category c = categoryMapper.selectOne(l);

        if(c == null){
            res.setMsg(Msg.Fail.NoCategory(name));
            return res;
        }else if(!c.isDeepest()){ // Can't delete the non-deepest category
            res.setMsg(Msg.Fail.Subcategory());
            return res;
        }

        Category parent = categoryMapper.selectById(c.getPid());
        if(parent != null){
            LambdaQueryWrapper<Category> nos = new LambdaQueryWrapper<>();
            nos.eq(Category::getPid, parent.getId());
            nos.ne(Category::getName, c.getName());
            List<Category> sons = categoryMapper.selectList(nos);
            if(sons.isEmpty()){ // No other sons, delete and make parent the deepest.
                parent.setDeepest(true);
                categoryMapper.updateById(parent);
            }
        }else if(c.getPid() == 0){ // The topmost, but also the deepest.
            // Just do nothing.
        }else{
            res.setMsg(Msg.Fail.ISE());
            return res;
        }

        categoryMapper.deleteById(c.getId());

        // Check if it has been deleted.
        if(categoryMapper.selectOne(l) == null){
            res.setStatus(true);
            res.setMsg(Msg.Success.DeleteCategory(name));
        }else{
            res.setMsg(Msg.Fail.ISE());
        }

        return res;
    }

    public static Response addBook(String ISBN,
                                   String name,
                                   String author,
                                   String publisher,
                                   String summary,
                                   String cover,
                                   Float price,
                                   Integer stock,
                                   String category){
        Response res = new Response(false, Op.ADD_BOOK);
        LambdaQueryWrapper<Book> l = new LambdaQueryWrapper<>();
        l.eq(Book::getISBN, ISBN);

        if(null != bookMapper.selectOne(l)){ // if not null, means book has existed.
            res.setMsg(Msg.Fail.BookExisted(ISBN));
            return res;
        }
        if(category != null){ // Skip when category is indefinite.
            LambdaQueryWrapper<Category> lc = new LambdaQueryWrapper<>();
            lc.eq(Category::getName, category);
            Category c = categoryMapper.selectOne(lc);
            if(c == null){ // if category doesn't exist
                res.setMsg(Msg.Fail.NoCategory(category));
                return res;
            }
//            else if(!c.isDeepest()){
//                res.setMsg(category + " is not the deepest one.");
//                return res;
//            }
        }

        // Dealing indefinite column.
        if(price == null) price = 0F;
        if(stock == null) stock = 0;

        bookMapper.insert(new Book(ISBN, name, author, publisher,
                summary, cover, price, stock, category));

        if(bookMapper.selectOne(l) != null){ // insert successfully
            res.setStatus(true);
            res.setMsg(Msg.Success.AddBook());
        }else{
            res.setMsg(Msg.Fail.ISE());
        }

        return res;
    }

    public static Response deleteBook(String ISBN){
        LambdaQueryWrapper<Book> l = new LambdaQueryWrapper<>();
        l.eq(Book::getISBN, ISBN);
        Book book = bookMapper.selectOne(l);
        Response res = new Response(false, Op.DELETE_BOOK);

        if(book == null){
            res.setMsg(Msg.Fail.BookNotExist(ISBN));
            return res;
        }

        // TODO -> if book is being borrowed, it cannot be deleted.

        bookMapper.deleteById(book);

        if(bookMapper.selectOne(l) == null){ // successfully deleted.
            res.setStatus(true);
            res.setMsg(Msg.Success.DeleteBook());
        }else{
            res.setMsg(Msg.Fail.ISE());
        }

        return res;
    }

    public static BookResponse getBookByCategory(String category){
        BookResponse res = new BookResponse(false, Op.GET_BOOK_CATEGORY);
        LambdaQueryWrapper<Category> l1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Book> l2 = new LambdaQueryWrapper<>();
        l1.eq(Category::getName, category);
        l2.eq(Book::getCategory, category);
        if(categoryMapper.selectOne(l1) == null){ // category doesn't exist
            res.setMsg(Msg.Fail.NoCategory(category));
            return res;
        }

        List<Book> bks = bookMapper.selectList(l2);
        res.setBooks(bks);
        if(bks.isEmpty()){
            res.setMsg(Msg.Fail.NoBookCategory(category));
        }else{
            res.setStatus(true);
            res.setMsg(Msg.Success.GetBook());
        }

        return res;
    }

    public static BookResponse getBookByName(String name){
        BookResponse res = new BookResponse(false, Op.GET_BOOK_NAME);
        LambdaQueryWrapper<Book> l = new LambdaQueryWrapper<>();
        l.like(Book::getName, name); // %category%, such as "ma -> math"

        List<Book> bks = bookMapper.selectList(l);
        res.setBooks(bks);

        if(bks.isEmpty()){
            res.setMsg(Msg.Fail.NoBookName(name));
        }else{
            res.setStatus(true);
            res.setMsg(Msg.Success.GetBook());
        }
        return res;
    }

    public static Response updateBook(Book newBook){
//        System.out.println(newBook.toString());
        Response res = new Response(false, Op.UPDATE_BOOK);
        LambdaQueryWrapper<Book> l = new LambdaQueryWrapper<>();
        l.eq(Book::getISBN, newBook.getISBN());
        Book book = bookMapper.selectOne(l);
        if(book == null){ // Book doesn't exist.
            res.setMsg(Msg.Fail.BookNotExist(newBook.getISBN()));
            return res;
        }
        LambdaUpdateWrapper<Book> luw = new LambdaUpdateWrapper<>();
        luw.eq(Book::getISBN, newBook.getISBN());
        bookMapper.update(newBook, luw);
        res.setStatus(true);
        res.setMsg(Msg.Success.UpdateBook());
        return res;
    }

//     With transaction.
//    public static Response borrowBook(int bookId, int duration, float fine, String account){
//        Response res = new Response(false, Op.BORROW_BOOK);
//        Book book = bookMapper.selectById(bookId);
//        Account acc = accountMapper.selectById(account);
//
//        if(acc == null){
//            res.setMsg(Msg.Fail.AccountNotExist(account));
//        }else if(book == null){ // Book does not exist
//            res.setMsg(Msg.Fail.NoBookId(bookId));
//        }else if(book.getStock() <= 0){ // Book is out of stock.
//            res.setMsg(Msg.Fail.BookOutOfStock(book.getISBN(), book.getName()));
//        }else if(book.beBorrowed()){ // Successfully being borrowed.
//            bookMapper.updateById(book);
//            String now = sdf.format(new Date());
//            Borrow borrow = new Borrow(now, book.getId(), duration, false, fine, account);
//            borrowMapper.insert(borrow);
//            res.setStatus(true);
//            res.setMsg(Msg.Success.BorrowBook());
//        }else{
//            res.setMsg(Msg.Fail.ISE());
//        }
//
//        return res;
//    }

    /**
     * borrow a book
     */
    public static Response borrowBook(int id, String name, String inbs, int dates,String userName){
        Response response = new Response(false,Op.BORROW_BOOK);
        Book book = bookMapper.selectById(id);
        if(book == null)
            response.setMsg(Msg.Fail.noBookName(name));
        else{
            if(book.getStock() <= 0)
                response.setMsg(Msg.Fail.noBookStock(name));
            else if(book.beBorrowed()){
//                 String now = sdf.format(dates[0]);
//                 String to = sdf.format(dates[1]);
//                 String duration = now + to;
                 String now = sdf.format(new Date());
                 int duration = dates;
                 //int len = borrowMapper.selectCount(new Borrow());
                 Borrow borrow = new Borrow(now, book.getId(),duration, false, 0.0F, userName);
                 borrowMapper.insert(borrow);
                 bookMapper.updateById(book);
                 response.setStatus(true);
                 response.setMsg(Msg.Success.BorrowBook());
            }else
                response.setMsg(Msg.Fail.ISE());
        }
        return response;
    }

    public static Response returnBook(int bookId, boolean isDamaged, String account, int borrowId){
        Response res = new Response(false, Op.RETURN_BOOK);
        Book book = bookMapper.selectById(bookId);
        Account acc = accountMapper.selectById(account);

        if(acc == null){
            res.setMsg(Msg.Fail.AccountNotExist(account));
            return res;
        }else if(book == null){
            res.setMsg(Msg.Fail.NoBookId(bookId));
            return res;
        }

        Borrow borrow = borrowMapper.selectById(borrowId);

        if(borrow == null){ // Borrow record does not exist.
            res.setMsg(Msg.Fail.BorrowNotExist(borrowId));
        }else if(book.getId() != borrow.getBookId()){ // Book id and borrow id does not match each other.
            res.setMsg(Msg.Fail.BookUnMatchBorrow());
        }else if(!account.equals(borrow.getAccount())){ // Account unmatched.
            res.setMsg(Msg.Fail.NotYourBorrow());
        }else if(isDamaged || borrow.isOverTime()){ // Should pay the fine.
            res.setMsg(Msg.Fail.PayFine(borrow));
        }else if(book.beReturned()){ // Successfully be returned.
            bookMapper.updateById(book);
            borrowMapper.deleteById(borrow);
            res.setStatus(true);
            res.setMsg(Msg.Success.ReturnBook());
        }else{
            res.setMsg(Msg.Fail.ISE());
        }

        return res;
    }

    private static void performChange(String newPassword, Response res, LambdaQueryWrapper<Account> lTarget, Account target) {
        target.setPassword(newPassword);
        accountMapper.updateById(target);
        if(accountMapper.selectOne(lTarget).getPassword().equals(newPassword)){
            res.setStatus(true);
            res.setMsg(Msg.Success.ChangePassword());
        }else{
            res.setMsg(Msg.Fail.ISE());
        }
    }

    /**
     * 封装方法用于解析前端传来的Json串
     */
    public static List<String> jToV(String josn){
        JSONParser jsonParser = new JSONParser(josn);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        try {
            map = jsonParser.parseObject();
            for(Map.Entry<String, Object> entry : map.entrySet()){
                System.out.println(entry.getValue());
                list.add((String) entry.getValue());
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 解析token获取用户信息
     */
    public static AccountResponse getStatues(String token){
        AccountResponse res = new AccountResponse(false, Op.GET_ACCOUNT);
        LambdaQueryWrapper<Token> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Token::getToken_info,token);
        Token token1 =tokenMapper.selectOne(lqw);
//        String name =token1.getAccount();
        if(token1 != null){
            String name =token1.getAccount();
            LambdaQueryWrapper<Account> lqw1 = new LambdaQueryWrapper<>();
            lqw1.eq(Account::getName , name);
            List<Account> list = accountMapper.selectList(lqw1);
            Account account = list.get(0);
            account.setPassword("");
            list.set(0,account);
            res.setAccounts(list);
            res.setStatus(true);
            res.setMsg(Msg.Success.getUserStatus());
        }else {
            res.setMsg(Msg.Fail.noToken());
        }
        return res;
    }

    public static BoInfoResponse booKBorrowInfo(int page, int num){
        BoInfoResponse res = new BoInfoResponse(false,Op.GET_BORROWINFO);
        List<BookVo> list = borrowMapper.bookList(new Page<>(page,num));
        if(list.size() != 0){
            res.setInfoList(list);
            res.setStatus(true);
            res.setMsg(Msg.Success.getBorrowInfo());
        }else{
            res.setMsg(Msg.Fail.noBorrowBookId());
        }
        return res;
    }
    public static BoInfoResponse booKBorrowInfo(String name ,String date1,int date2, int page, int num){
        BoInfoResponse res = new BoInfoResponse(false,Op.GET_BORROWINFO);
        List<BookVo> list = borrowMapper.bookList1(new Page<>(page,num),name,date1,date2);
        if(list.size() != 0){
            res.setInfoList(list);
            res.setStatus(true);
            res.setMsg(Msg.Success.getBorrowInfo());
        }else{
            res.setMsg(Msg.Fail.noBorrowBookId());
        }
        return res;
    }

}
