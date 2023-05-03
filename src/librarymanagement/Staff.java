package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
import java.util.Hashtable;
/**
 *
 * @author hqara
 */
public class Staff extends Account {
    
     public Staff(String accountID, String password) 
     {
        super(accountID, password);
        Library.staffDatabase.put(Integer.parseInt(accountID), this);
     }
    
     public void addBook(Book book) 
     {
        Library.bookDatabase.put(book.getBookID(), book);
        //Library.reserialize();
        System.out.println(book.getTitle()+ " #"+book.getBookID()+" was added to the Library!");
     }
    
     //tentative parameters: int bookID, boolean isReserved
     public void markBookReserved() 
     {
        // Code to mark a book as reserved or not reserved
     }
   
    //tentative parameters: all properties from Book Class
     public void modifyBook(int bookId, Book book) 
     {
             Library.bookDatabase.remove(bookId);
             Library.bookDatabase.put(book.getBookID(), book);
             //Library.reserialize();
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

