package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author szakr
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

    public User(int accountID, String password, String fname, String lname, boolean isMember) 
    {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname;
        this.isMember=isMember;
    }
    
    //Send request to get membership, then a staff employee will add user as a member
    public void applyForMembership()
    {
        this.isMember = true;
    }
    
    public void borrowBook(int bookID, String borrowerName)
    {
        if (!Library.books().containsKey(bookID)) {
            System.out.println("Book ID=" + bookID + " does not exist in the Library database.");
        }
        else if (!Library.books().get(bookID).isAvailable() == true) {
            System.out.println("Sorry " + borrowerName + ", the book " + getBookTitleByID(bookID) + " is already borrowed by someone else.");
        }
        else{
            Library.lendBook(bookID, false);
            System.out.println(borrowerName + " is borrowing the book " + getBookTitleByID(bookID) + ".");
        }
    }

    //Return a book
    public void returnBook(int bookID, String borrowerName)
    {
        if (!Library.books().containsKey(bookID)) {
            System.out.println("Book ID=" + bookID + " does not exist in the Library database.");
        }
        else if (Library.books().get(bookID).isAvailable() == true) {
        System.out.println("The book " + getBookTitleByID(bookID) + " has not been borrowed yet.");
        }
        else{
            Library.lendBook(bookID, true);
            System.out.println("The book " + getBookTitleByID(bookID) + " has been returned by " + borrowerName + ".");
        }
    }
    
    @Override
    public void searchBook(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
           Book book = Library.books().get(bookId);
           System.out.println("Book ID="+bookId+"("+ getBookTitleByID(bookId) +") is available in the Library.");
        }
        System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
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
    
    public boolean isMember() 
    {
        return isMember;
    }
    
     public boolean isBookAvailable(int bookID) 
     {
        if (Library.books().containsKey(bookID)) {
            Book book = Library.books().get(bookID);
            return book.isAvailable;
        }
        return false;
     }
    
    public String getBookTitleByID(int bookID) 
    {
        if (Library.books().containsKey(bookID)) {
            Book book = Library.books().get(bookID);
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
       return String.format("User_ID=%d, Last_Name=%s, First_Name=%s, Is_Member=%b", 
               super.getAccountID(), lastName, firstName, isMember);
    }

    public int AccountLoggedIn() 
    {
        return 3;
    }
}
