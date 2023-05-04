package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class Book {
    private String title;
    private String author;
    private int bookID;
    private int price;
    private static int count = 0;
    protected boolean isReserved = false; // by default, only a staff employee can mark up a book as reserved
    protected boolean isAvailable = true; // by default, book is available until a staff employee lend the book to a registered user
        
    public Book(int id, String title, String author, int price)
    {
        this.bookID = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static int nextID()
    {
        // to modify later, I am using this for a test
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

    public int getPrice() 
    {
        return price;
    }
    
    public boolean isReserved()
    {
        return isReserved;
    }
    
    public boolean isAvailable() {
        return isAvailable;
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

    public void setPrice(int price) 
    {
        this.price = price;
    }
    
    public void setReserved(boolean reserved) 
    {
        this.isReserved = reserved;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
   
    @Override
    public String toString()
    {
       return String.format("Book_ID=%d, Book_Title=%s, Author=%s, Price=%d, is_Book_Reserved=%b, is_Book_Available=%b\n", 
               bookID, title, author, price, isReserved(), isAvailable()); 
    }
}
