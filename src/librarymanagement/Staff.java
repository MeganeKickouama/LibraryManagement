package librarymanagement;
 
import java.util.Hashtable;
import librarymanagement.User;
/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class Staff extends Account implements LogIn {
    
     private String firstName;
     private String lastName;
     
     public Staff(int accountID, String password) 
     {
        super(accountID, password);
     }
     
     public Staff(int accountID, String password, String fname, String lname) 
     {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname; 
     }
     
     public void addBook(Book book) 
     {
        Library.books().put(book.getBookID(), book);
        Library.serialize("JSON_Database/bookDatabase.json", Library.books());
        System.out.println(book.getTitle()+ " ID="+book.getBookID()+" was added to the Library database.");
     }
     
     
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
    
     public void modifyBook(int bookId, String newTitle, String newAuthor) 
     {
        if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
                
            // Update the book in the hashtable
            Library.books().remove(bookId);
            Library.books().put(bookId, book);
            Library.serialize("JSON_Database/bookDatabase.json", Library.books());
            System.out.println("Book ID=" + bookId + " has been updated with the new information.");
            } else {
                System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
            }
     }

    public void markBookReserved(int bookId) 
    {
        Book book = Library.books().get(bookId);
        if (book != null) {
            if (book.isReserved() == true) {
                System.out.println("This book is already reserved.");
            } else {
                book.setReserved(true);
                System.out.println("Book is now reserved.");
                Library.books().put(book.getBookID(), book);
                Library.serialize("JSON_Database/userDatabase.json", Library.books());
            }
        } else {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }

    public void markBookUnreserved(int bookId) 
    {
        Book book = Library.books().get(bookId);
        if (book != null) {
            if (book.isReserved() == false) {
                System.out.println("This book is already unreserved.");
            } else {
                book.setReserved(false);
                System.out.println("Book is now unreserved.");
                Library.books().put(book.getBookID(), book);
                Library.serialize("JSON_Database/userDatabase.json", Library.books());
            }
        } else {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }

     public void addMember(int userId) 
     {
        User member = (User) Library.users().get(userId);
        if (member == null) {
            System.out.println("User ID=" + userId + " does not exist in the Library database");
            return;
        }
        if (member.isMember()) {
            return; // User is already a member, do nothing
        }
        member.applyForMembership();
        Library.users().put(member.getAccountID(), member);
        Library.serialize("JSON_Database/userDatabase.json", Library.users());
        System.out.println("User ID=" + userId + " is officially registered as a member.");
    }
     

      public void lendBook(int bookId) 
    {
        if (!Library.books().containsKey(bookId)) {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        } else if (!Library.books().get(bookId).isAvailable()) {
            System.out.println("The book " + getBookTitleByID(bookId) + " is already lent to someone else.");
        } else {
          
            if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            book.setAvailable(false);
        }
            System.out.println("The book " + getBookTitleByID(bookId) + " has been successfully lent.");
        }
    }

    
    @Override
    public void searchBook(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
            System.out.print("Found: " + Library.books().get(bookId).toString());
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
  
    public String getBookTitleByID(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            return book.getTitle();
        }
        return null;
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
       return String.format("Staff_ID=%d, Last_Name=%s, First_Name=%s\n", super.getAccountID(), lastName, firstName); 
    }

    @Override
    public int AccountLoggedIn() 
    {
        return 1;
    }

}

