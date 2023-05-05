package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.Hashtable;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */
public class Library {

    public static Library instance = null;
    
    private static Hashtable<Integer, Book> bookDatabase = new Hashtable<>();
    private static Hashtable<Integer, Account> userDatabase = new Hashtable<>();
    private static Hashtable<Integer, Account> supplierDatabase = new Hashtable<>();
    private static Hashtable<Integer, Account> staffDatabase = new Hashtable<>();

    private Library()
    {
        
    }

    public static Library getLibrary()
    {
        if (instance == null)
        {
            return new Library();
        }

        return instance;
    }

    // Convert obj to JSONobj
    public static void serialize(String file, Hashtable database)
    {
        try 
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); // makes it so that you don't need a setter or getter
            mapper.writeValue(Paths.get(file).toFile(), database);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Convert the json file to a hashtable
    public static void deserialize(String file, Hashtable database)
    {
        try 
        {
            database.clear();
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // makes it so that you don't need a setter or getter
            
            if (file.contains("book"))
            {
                Hashtable<Integer, Book> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                database.putAll(temp);
            }
            else if (file.contains("staff") || file.contains("user") || file.contains("supplier"))
            {
                Hashtable<String, Account> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                database.putAll(temp);
            }
            else 
            {
                Hashtable temp = null;
                database.putAll(temp);
            } 
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //Singleton Library class is like an Admin that can add/remove elements from the System!
    
    public static void addUser(User user)
    {
         users().put(user.getAccountID(), user);
         serialize("JSON_Database/userDatabase.json", users());
         System.out.println("User ID=" + user.getAccountID() + " was added to the Library database.");
    }
    
    public static void addStaff(Staff staff)
    {
         staffs().put(staff.getAccountID(), staff);
         serialize("JSON_Database/staffDatabase.json", staffs());
         System.out.println("Staff ID=" + staff.getAccountID() + " was added to the Library database");
    }
    
    public static void addSupplier(Supplier supplier)
    {
         suppliers().put(supplier.getAccountID(), supplier);
         serialize("JSON_Database/supplierDatabase.json", suppliers());
         System.out.println("Supplier ID=" + supplier.getAccountID() + "was added to the Library database.");
    }
    
    public static void removeUser(int userId)
    {
        if (users().containsKey(userId)) {
            users().remove(userId);
            serialize("JSON_Database/userDatabase.json", users());
            System.out.println("User ID=" + userId + "was removed from the Library database.");
        } else {
            System.out.println("User ID=" + userId + " does not exist in the Library database.");
        }
    }
    
    public static void removeStaff(int staffId)
    {
         if (staffs().containsKey(staffId)) {
            staffs().remove(staffId);
            serialize("JSON_Database/staffDatabase.json", staffs());  
            System.out.println("Staff ID=" + staffId + "was removed from the Library database.");
        } else {
            System.out.println("Staff ID=" + staffId + " does not exist in the Library database.");
        }
    }
    
    public static void removeSupplier(int supplierId)
    {
          if (suppliers().containsKey(supplierId)) {
            suppliers().remove(supplierId);
            serialize("JSON_Database/supplierDatabase.json", suppliers());  
            System.out.println("Supplier ID=" + supplierId + "was removed from the Library database.");
        } else {
            System.out.println("Supplier ID=" + supplierId + " does not exist in the Library database.");
        }
    }
    
    
    public static void lendBook(int bookID, boolean isAvailable) {
        if (books().containsKey(bookID)) {
            Book book = books().get(bookID);
            book.setAvailable(isAvailable);
        }
    }

    // Database Getter Methods
    
    public static Hashtable<Integer, Book> books()
    {
        return bookDatabase;
    }
    
    public static Hashtable<Integer, Account> staffs()
    {
        return staffDatabase;
    }
    
    public static Hashtable<Integer, Account> suppliers()
    {
        return supplierDatabase;
    }
    
    public static Hashtable<Integer, Account> users()
    {
        return userDatabase;
    }
}
