package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Hashtable;
import java.io.*;
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
    
    static Hashtable<Integer, Book> bookDatabase = new Hashtable<>();
    static Hashtable<Integer, Account> userDatabase = new Hashtable<>();
    static Hashtable<Integer, Account> supplierDatabase = new Hashtable<>();
    static Hashtable<Integer, Account> staffDatabase = new Hashtable<>();


    static final String databaseFile = "";

    private Library()
    {
        // ?
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
    public static void serialize(File file)
    {
        // to parse (e.g. book class json file)
        /*
         * List<Book> books = objectMapper.readValue(new File("file.json"), new TypeReference<List<Book>>() {})
         */
        // TODO WRITE TO FILE 
        // TODO DO THE SAME FOR THE 3 OTHER HASHTABLES
        try 
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // makes it so that you don't need a setter or getter
            String json = mapper.writeValueAsString(bookDatabase);
            //mapper.writeValue(file, json);
            System.out.println(json); // change to write to file

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // to convert the json file to a hashtable
    public void deserialize(File file)
    {

        // TODO WRITE TO FILE 
        // TODO DO THE SAME FOR THE 3 OTHER HASHTABLES
        try 
        {
            Hashtable<Integer, Book> temp = bookDatabase;
            bookDatabase.clear();
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // makes it so that you don't need a setter or getter
            bookDatabase = mapper.readValue(
                file, new TypeReference<Hashtable<Integer, Book>>() {});
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // for when an element is either deleted or added
    public static void reserialize()
    {
        // to parse (e.g. book class json file)
        /*
         * List<Book> books = objectMapper.readValue(new File("file.json"), new TypeReference<List<Book>>() {})
         */
        // TODO WRITE TO FILE 
        // TODO DO THE SAME FOR THE 3 OTHER HASHTABLES
        try 
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // makes it so that you don't need a setter or getter
            String json = mapper.writeValueAsString(bookDatabase);
            System.out.println(json); // change to write to file

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
