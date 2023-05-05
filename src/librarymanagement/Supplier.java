package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author szakr
 * @author scol
 */
public class Supplier extends Account implements LogIn{
    
    private String supplierName;
    private int balance;

    public Supplier(int accountID, String password) 
    {
        super(accountID, password);
    }
      
    public Supplier(int accountID, String password, String name) 
    {
        super(accountID, password);
        this.supplierName=name;
    }
    
    public void sellBook(int bookID, int quantity, int price)
    {
        Book book = Library.books().get(bookID);
        
        if (!Library.books().containsKey(bookID)) {
            System.out.println("Book ID=" + bookID + " does not exist in the Library database.");
        }
        else if (book.getQuantity() < quantity) {
            System.out.println("The supplier does not have enough copies of " + getBookTitleByID(bookID) + ".");
        }
        else{        
            book.setQuantity(book.getQuantity() - quantity);

            double revenue = quantity * price;
            balance += revenue;
            System.out.println("Sold " + quantity + " copies of " + getBookTitleByID(bookID) + " for a total revenue of $" + revenue + ".");
        }
    }
    
    public String getBookTitleByID(int bookID) 
    {
        if (Library.books().containsKey(bookID)) {
            Book book = Library.books().get(bookID);
            return book.getTitle();
        }
        return null;
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
    public String getSupplierName() 
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public int getBalance() 
    {
        return balance;
    }

    public void setBalance(int balance) 
    {
        this.balance = balance;
    }
    
    @Override
    public String toString()
    {
       return String.format("Supplier_ID=%d, Name=%s, Balance=%d", super.getAccountID(), supplierName, balance); 
    }    

    public int AccountLoggedIn() 
    {
        return 2;
    }
}
