package librarymanagement;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */
import static librarymanagement.Library.users;

public class User extends Account implements LogIn{

    private String firstName;
    private String lastName;
    private boolean isMember = false; // by default, users are not members
    
    public User(int accountID, String password) 
    {
        super(accountID, password);
    }
      
    public User(int accountID, String password, String fname, String lname) 
    {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname;
    }
    
    // Register as an official member
    public void applyForMembership(int userId) 
    {
        User member = (User) Library.users().get(userId);
        if (member == null) {
            System.out.println("User ID=" + userId + " does not exist in the Library database");
            return;
        }
        if (member.isMember() == true) {
            System.out.println("User ID=" + userId + " is already registered as a member.");
            return; // User is already a member, do nothing
        }
        member.requestMembership();
        Library.users().put(member.getAccountID(), member);
        Library.serialize("JSON_Database/userDatabase.json", Library.users());
        System.out.println("User ID=" + userId + " is officially registered as a member.");
    }
    
    
    public void borrowBook(int bookId) 
    {
        if (!Library.books().containsKey(bookId)) {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        } else if (!Library.books().get(bookId).isAvailable()) {
            System.out.println("The book " + getBookTitleByID(bookId) + " is already borrowed by someone else.");
        } else {
            if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            book.setAvailable(false);
        }
            System.out.println("The book " + getBookTitleByID(bookId) + " has been successfully borrowed.");
        }
    }


    //Return a book
    public void returnBook(int bookId)
    {
        if (!Library.books().containsKey(bookId)) {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
        else if (Library.books().get(bookId).isAvailable() == true) {
        System.out.println("The book " + getBookTitleByID(bookId) + " has not been borrowed yet.");
        } else {
                if (Library.books().containsKey(bookId)) {
                    Book book = Library.books().get(bookId);
                    book.setAvailable(true);
                    System.out.println("The book " + getBookTitleByID(bookId) + " has been returned.");
               }
        }
    }
    
    @Override
    public void searchBook(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
           System.out.print("Found: "+Library.books().get(bookId).toString());
        } else {
        System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }
    
    // Getter methods
    public boolean isBookAvailable(int bookID) 
     {
        if (Library.books().containsKey(bookID)) {
            Book book = Library.books().get(bookID);
            return book.isAvailable();
        }
        return false;
     }
    
    public String getBookTitleByID(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
            Book book = Library.books().get(bookId);
            return book.getTitle();
        }
        return null;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }
    
    public boolean isMember() 
    {
        return isMember;
    }
    
    public void requestMembership()
    {
        this.isMember = true;
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

    public boolean setMember(boolean isMember) 
    {
        return isMember;
    }
    
    @Override
    public String toString()
    {
       return String.format("User_ID=%d, Last_Name=%s, First_Name=%s, Is_Member=%b\n", 
               super.getAccountID(), lastName, firstName, isMember);
    }

    @Override
    public int AccountLoggedIn() 
    {
        return 3;
    }
}
