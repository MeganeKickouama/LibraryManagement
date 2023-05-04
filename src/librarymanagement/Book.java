package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author szakr
 * @author kmega
 * @author hqara
 */

public class Book {
    private String title;
    private String author;
    private int bookID;
    private int price;
    private static int count = 0;

    public Book(String title, String author, int price, int id)
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
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookID() {
        return bookID;
    }

    public int getPrice() {
        return price;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString()
    {
       return String.format("ID=%d, Title=%s, Author=%s, Price=%d", bookID, title, author, price); 
    }
}
