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
    
     private String firstName;
     private String lastName;
     
     public Staff(int accountID, String password, String fname, String lname) 
     {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname;
        //Library.staff().put(super.getAccountID(),);
        Library.serialize("JSON_Database/staffDatabase.json", Library.staffs());
        
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

    /*public void addMember(User member) 
    {
        Library.books().remove(member.getAccountID());
        member = member.applyForMembership();
        Library.users().put(member.getAccountID(),member);
        Library.serialize("JSON_Database/userDatabase.json", Library.users());
        
    }*/
    public void addMember(User member) 
    {
        if (member.isMember() == true) {
            return; // User is already a member, do nothing
        }
            member.applyForMembership();
            Library.users().put(member.getAccountID(),member);
            Library.serialize("JSON_Database/userDatabase.json", Library.users());
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
    
     
    public void deleteBook(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            Library.books().remove(bookId);
            Library.serialize("JSON_Database/bookDatabase.json", Library.books());
            System.out.println("Book ID=" + bookId + "(" + book.getTitle() + ")" + " was removed from the Library database.");
        } else {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }
    
    // Getter methods
    
    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }
    
    // Setter methods
    
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
       return String.format("Staff_ID=%d, Last_Name=%s, First_Name=%s", super.getAccountID(), lastName, firstName); 
    }

}

