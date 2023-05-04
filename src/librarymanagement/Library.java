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

    // to convert obj to JSONobj
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
    
    // to convert the json file to a hashtable
    public static void deserialize(String file, Hashtable database)
    {
        // TODO WRITE TO FILE 
        // TODO DO THE SAME FOR THE 3 OTHER HASHTABLES
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
         Library.users().put(user.getAccountID(), user);
         Library.serialize("JSON_Database/userDatabase.json", Library.users());
    }
    
    public static void addStaff(Staff staff)
    {
         Library.staffs().put(staff.getAccountID(), staff);
         Library.serialize("JSON_Database/staffDatabase.json", Library.staffs());
    }
    
    public static void addSupplier(Supplier supplier)
    {
         Library.suppliers().put(supplier.getAccountID(), supplier);
         Library.serialize("JSON_Database/supplierDatabase.json", Library.suppliers());
    }
    
    public static void removeUser(int userId)
    {
        if (Library.users().containsKey(userId)) {
            Library.users().remove(userId);
            Library.serialize("JSON_Database/userDatabase.json", Library.users());  
        } else {
            System.out.println("User ID=" + userId + " does not exist in the Library database.");
        }
    }
    
    public static void removeStaff(int staffId)
    {
         if (Library.staffs().containsKey(staffId)) {
            Library.users().remove(staffId);
            Library.serialize("JSON_Database/staffDatabase.json", Library.users());  
        } else {
            System.out.println("User ID=" + staffId + " does not exist in the Library database.");
        }
    }
    
    public static void removeSupplier(int supplierId)
    {
          if (Library.suppliers().containsKey(supplierId)) {
            Library.users().remove(supplierId);
            Library.serialize("JSON_Database/supplierDatabase.json", Library.suppliers());  
        } else {
            System.out.println("User ID=" + supplierId + " does not exist in the Library database.");
        }
    }
    
    /* DATABASE GETTERS */
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
