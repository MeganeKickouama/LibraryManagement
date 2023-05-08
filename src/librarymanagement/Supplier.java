package librarymanagement;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class Supplier extends Account implements LogIn{
    
    private String supplierName;
    private double balance;

    public Supplier(int accountID, String password) 
    {
        super(accountID, password);
    }
      
    public Supplier(int accountID, String password, String name) 
    {
        super(accountID, password);
        this.supplierName=name;
        this.balance = 0;
    }
        
    public void sellBook(int supplierID, int bookID, int quantity) 
    {
         Supplier supplier = (Supplier) Library.suppliers().get(supplierID);
        if (supplier.getAccountID() != supplierID) {
            System.out.println("Incorrect User ID: Attempt to sell a book failed.");
            return;
        }
        Book book = Library.books().get(bookID);
        if (!Library.books().containsKey(bookID)) {
            System.out.println("Book ID=" + bookID + " does not exist in the Library database.");
        } else{        
            book.setQuantity(book.getQuantity() + quantity);
            double revenue = quantity * book.getPrice();
            supplier.setBalance(revenue+supplier.getBalance());
            System.out.println("Sold " + quantity + " copies of " + getBookTitleByID(bookID)
                    + " for a total revenue of $" + revenue + ".");
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
    public String getBookTitleByID(int bookID) 
    {
        if (Library.books().containsKey(bookID)) {
            Book book = Library.books().get(bookID);
            return book.getTitle();
        }
        return null;
    }
    
    public String getSupplierName() 
    {
        return supplierName;
    }

    public double getBalance() 
    {
        return balance;
    }

    //Setter
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }
    
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
    
    @Override
    public String toString()
    {
       return String.format("Supplier_ID=%d, Name=%s, Balance=$%4.2f\n", 
               super.getAccountID(), supplierName, getBalance()); 
    }    

    @Override
    public int AccountLoggedIn() 
    {
        return 2;
    }
}
