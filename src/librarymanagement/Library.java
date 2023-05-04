package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Hashtable;
import java.io.*;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author szakr
 * @author kmega
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
    
    // for when an element is either deleted or added
    public static void remove(int id)
    {
        
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
