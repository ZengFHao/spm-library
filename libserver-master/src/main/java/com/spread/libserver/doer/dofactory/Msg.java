package com.spread.libserver.doer.dofactory;

import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.Borrow;

public class Msg {

    private static String squareBracket(String str){
        return String.format("[%s]", str);
    }

    private static String bracket(String str){
        return String.format("(%s)", str);
    }

    public static class Success{
        public static Message Register(){
            return new Message("100", "Register successfully!");
        }

        public static Message Login(){
            return new Message("101", "Login successfully!");
        }

        public static Message ChangePassword(){
            return new Message("102", "Changed successfully!");
        }

        public static Message GetAllCategories(){
            return new Message("103", "Successfully get all categories!");
        }

        public static Message AddCategory(String name){
            return new Message("104", "Add category " + squareBracket(name) + " successfully!");
        }

        public static Message DeleteCategory(String name){
            return new Message("105", "Successfully deleted category " + squareBracket(name) + ".");
        }

        public static Message AddBook(){
            return new Message("106", "Successfully added book!");
        }

        public static Message DeleteBook(){
            return new Message("107", "Successfully deleted book!");
        }

        public static Message UpdateBook(){
            return new Message("108", "Update successfully!");
        }

        public static Message GetBook(){
            return new Message("109", "Get book successfully!");
        }

        public static Message BorrowBook(){
            return new Message("110", "Borrow book successfully!");
        }

        public static Message ReturnBook(){
            return new Message("111", "Return book successfully!");
        }
    }

    public static class Fail{
        public static Message ISE(){
            return new Message("000", "Internal-server error.");
        }

        public static Message AccountRegistered(String acc){
            return new Message("001", "Account name " + squareBracket(acc) + " has been registered.");
        }

        public static Message WrongPassword(String acc){
            return new Message("002", "Wrong password for " + squareBracket(acc));
        }

        public static Message AccountNotExist(String acc){
            return new Message("003", "Account name does not exist: " + squareBracket(acc) + ".");
        }

        public static Message TargetNotExist(String target){
            return new Message("004", "Target account " + squareBracket(target) + " does not exist.");
        }

        public static Message ChangeOtherManager(){
            return new Message("005", "You can't change other managers password!");
        }

        public static Message ChangeOther(){
            return new Message("006", "You can only change the password of your own.");
        }

        public static Message NoCategory(){
            return new Message("007", "There's no category.");
        }

        public static Message CategoryExisted(String name){
            return new Message("008", "Category " + squareBracket(name) + " has already existed.");
        }

        public static Message NoCategory(String name){
            return new Message("009", "There's no category named " + squareBracket(name) + ".");
        }

        public static Message Subcategory(){
            return new Message("010", "The current category includes subcategories.");
        }

        public static Message BookExisted(String ISBN){
            return new Message("011", "The book has been existed, ISBN: " + squareBracket(ISBN) + ".");
        }

        public static Message BookNotExist(String ISBN){
            return new Message("012", "Book " + squareBracket(ISBN) + " does not exist.");
        }

        public static Message NoBookCategory(String category){
            return new Message("013", "There's no book of this category: " + squareBracket(category) + ".");
        }

        public static Message NoBookName(String name){
            return new Message("014", "There's no book with the name: " + squareBracket(name) + ".");
        }

        public static Message NoBookId(int id){
            return new Message("015", "There's no book with the id: " + squareBracket(String.valueOf(id)) + ".");
        }



        public static Message BookOutOfStock(String ISBN, String name){
            return new Message("016", "Book " + squareBracket(name + bracket(ISBN)) + " is out of stock.");
        }

        public static Message BorrowNotExist(int id){
            return new Message("017", "There's no borrow record: " + squareBracket(String.valueOf(id)));
        }

        public static Message PayFine(Borrow borrow){
            return new Message("018", "You should pay the fine for the borrow " + squareBracket(borrow.getId().toString()) + ", amount is " + squareBracket(String.valueOf(borrow.getFine())));
        }

        public static Message NotYourBorrow(){
            return new Message("019", "It is not your borrow!");
        }

        public static Message BookUnMatchBorrow(){
            return new Message("020", "Book id and Borrow id does not match.");
        }

        public static Message noBookName(String  name){
            return new Message("021","There is no this book: " + squareBracket(name) );
        }
        public static Message noBookStock(String  name){
            return new Message("022","There is no stock with the book: " + squareBracket(name) );
        }
        public static Message typeMismatch(){
            return new Message("023","Account type mismatch");
        }
        public static Message wrongOldPswd(){
            return new Message("024","Old password is wrong");
        }
    }
}
