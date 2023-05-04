package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
import java.util.Hashtable;
/**
 *
 * @author hqara
 * @author kmega
 */
public class Staff extends Account {
    
     public Staff(String accountID, String password) 
     {
        super(accountID, password);
     }
    
     public void addBook(Book book) 
     {
        Library.books().put(book.getBookID(), book);
        Library.serialize("JSON_Database/bookDatabase.json", Library.books());
        System.out.println(book.getTitle()+ " ID="+book.getBookID()+" was added to the Library database.");
     }
    
     //tentative parameters: int bookID, boolean isReserved
     public void markBookReserved() 
     {
        // Code to mark a book as reserved or not reserved
     }
   
    //tentative parameters: all properties from Book Class
     public void modifyBook(int bookId, Book book) 
     {
             Library.books().remove(bookId);
             Library.books().put(book.getBookID(), book);
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

    /*public void deleteBook(Book book)
    {
       int id = book.getBookID();
       deleteBook(id);
       
    }*/
    
   /* public void deleteBook(int id)
    {
        Library.books().remove(id);
        Library.serialize("JSON_Database/bookDatabase.json", Library.books());
    }*/
    
     
    public void deleteBook(int bookId) {
        if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            Library.books().remove(bookId);
            Library.serialize("JSON_Database/bookDatabase.json", Library.books());
            System.out.println("Book ID=" + bookId + "(" + book.getTitle() + ")" + " was removed from the Library database.");
        } else {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }

}

