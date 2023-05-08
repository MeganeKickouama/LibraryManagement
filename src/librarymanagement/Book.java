package librarymanagement;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class Book {
    private String title;
    private String author;
    private int bookID;
    private double price;
    private int quantity;
    private static int count = 0;
    private boolean isReserved = false; // by default, only a staff employee can mark up a book as reserved
    private boolean isAvailable = true; // by default, book is available until a staff employee lend the book to a registered user
        
    
    public Book(int id, String title, String author, double price, int quantity)
    {
        this.bookID = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Book() {}

    public static int nextID()
    {
        count++;
        return count;
    }
    
     // Getter methods
    
    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public int getBookID() 
    {
        return bookID;
    }

    public double getPrice() 
    {
        return price;
    }
    
    public boolean isReserved()
    {
        return isReserved;
    }
    
    public boolean isAvailable() 
    {
        return isAvailable;
    }

    public int getQuantity() {
        return quantity;
    }
    
    // Setter methods
    
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public void setBookID(int bookID) 
    {
        this.bookID = bookID;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }
    
    public void setReserved(boolean reserved) 
    {
        this.isReserved = reserved;
    }

    public void setAvailable(boolean isAvailable) 
    {
        this.isAvailable = isAvailable;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString()
    {
       return String.format("Book_ID=%d, Book_Title=%s, Author=%s, Price=$%4.2f, Quantity=%d, is_Book_Reserved=%b, is_Book_Available=%b\n", 
               bookID, title, author, price, quantity, isReserved(), isAvailable()); 
    }
}
