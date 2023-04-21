package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
import java.util.Hashtable;
/**
 *
 * @author szakr
 */
public class Staff extends Account {

    //private Hashtable<Integer, Book> books;  
    //private Hashtable<String, User> members;
    //May be alternatively <String, Book> or <String, User>
    
     public Staff(String accountID, String password) 
     {
        super(accountID, password);
     }
    
     public Book addBook(Book book) 
     {
        // Code to add a book to the library and save in file
        //adding to the Book database hurray
     }
    
     //tentative parameters: int bookID, boolean isReserved
     public void markBookReserved() 
     {
        // Code to mark a book as reserved or not reserved
     }
   
    //tentative parameters: all properties from Book Class
     public void modifyBook() 
     {
        // Code to modify book information
     }

    //tentative parameters: int bookId and List <User> members?
    public void lendBook() 
    {
        // Code to lend a book to a list of users
    }

    public void addMember(User member) 
    {
        // Code to add a member 
    }

}
