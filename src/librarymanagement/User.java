package librarymanagement;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class User extends Account implements LogIn{

    private String firstName;
    private String lastName;
    protected boolean isMember = false; // by default, users are not members
    
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
    
    // Send request to upgrade as a member
    public void applyForMembership()
    {
        this.isMember = true;
        System.out.println("Thank you for your application. Our staff will review your request and upgrade your account"+
                "\nto an official member as soon as possible. We appreciate your interest in our library.");
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
       return String.format("User_ID=%d, Last_Name=%s, First_Name=%s, Is_Member=%b\n", 
               super.getAccountID(), lastName, firstName, isMember);
    }

    @Override
    public int AccountLoggedIn() 
    {
        return 3;
    }
}
