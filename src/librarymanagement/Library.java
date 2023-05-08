package librarymanagement;

import java.io.*;
import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;
import java.nio.file.Paths;
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
    
    private static ObjectMapper mapper = new ObjectMapper();

    private Library()
    {
        
    }

    public static Library getLibrary()
    {
        if (instance == null)
        {
            instance = new Library();
        }

        return instance;
    }

    public static void append(String file, Hashtable database) 
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

            if (file.contains("book")) {
                Hashtable<Integer, Book> temp = new Hashtable<>();
                File existingFile = new File(file);

                if (existingFile.exists()) {
                    temp = mapper.readValue(existingFile, new TypeReference<Hashtable<Integer, Book>>() {
                    });
                }

                temp.putAll(database);
                mapper.writerWithDefaultPrettyPrinter().writeValue(existingFile, temp);
            } else if (file.contains("staff") || file.contains("user") || file.contains("supplier")) {
                Hashtable<Integer, Account> temp = new Hashtable<>();
                File existingFile = new File(file);

                if (existingFile.exists()) {
                    temp = mapper.readValue(existingFile, new TypeReference<Hashtable<Integer, Account>>() {
                    });
                }

                temp.putAll(database);
                mapper.writerWithDefaultPrettyPrinter().writeValue(existingFile, temp);
            } else {
                System.out.println("Invalid file type.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Convert obj to JSONobj
    public static void serialize(String file, Hashtable database)
    {
        try 
        {
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY); 
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
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // makes it so that you don't need a setter or getter
            
            if (file.contains("book"))
            {
                Hashtable<Integer, Book> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                Set<Entry<Integer, Book>> entrySet = temp.entrySet();
        
                for(Entry<Integer, Book> entry : entrySet) {

                    database.put(entry.getKey(), entry.getValue());
                }
            }
            else if (file.contains("staff"))
            {
                Hashtable<Integer, Staff> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                Set<Entry<Integer, Staff>> entrySet = temp.entrySet();
        
                for(Entry<Integer, Staff> entry : entrySet) {

                    database.put(entry.getKey(), entry.getValue());
                }
            }
            else if (file.contains("user"))
            {
                Hashtable<Integer, User> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                database.putAll(temp);
                Set<Entry<Integer, User>> entrySet = temp.entrySet();
        
                for(Entry<Integer, User> entry : entrySet) {

                    database.put(entry.getKey(), entry.getValue());
                }
            } 
            else if (file.contains("supplier"))
            {
                Hashtable<Integer, Supplier> temp = mapper.readValue(Paths.get(file).toFile(), Hashtable.class);
                database.putAll(temp);
                Set<Entry<Integer, Supplier>> entrySet = temp.entrySet();
        
                for(Entry<Integer, Supplier> entry : entrySet) {

                    database.put(entry.getKey(), entry.getValue());
                }
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
         //System.out.println("User ID=" + user.getAccountID() + " was added to the Library database.");
    }
    
    public static void addStaff(Staff staff)
    {
         staffs().put(staff.getAccountID(), staff);
         serialize("JSON_Database/staffDatabase.json", staffs());
         //System.out.println("Staff ID=" + staff.getAccountID() + " was added to the Library database");
    }
    
    public static void addSupplier(Supplier supplier)
    {
         suppliers().put(supplier.getAccountID(), supplier);
         serialize("JSON_Database/supplierDatabase.json", suppliers());
         //System.out.println("Supplier ID=" + supplier.getAccountID() + " was added to the Library database.");
    }
    
    public static void removeUser(int userId)
    {
        if (users().containsKey(userId)) {
            users().remove(userId);
            serialize("JSON_Database/userDatabase.json", users());
            System.out.println("User ID=" + userId + " was removed from the Library database.");
        } else {
            System.out.println("User ID=" + userId + " does not exist in the Library database.");
        }
    }
    
    public static void removeStaff(int staffId)
    {
         if (staffs().containsKey(staffId)) {
            staffs().remove(staffId);
            serialize("JSON_Database/staffDatabase.json", staffs());  
            System.out.println("Staff ID=" + staffId + " was removed from the Library database.");
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
    
    public static void addBook(Book book)
    {
         books().put(book.getBookID(), book);
         serialize("JSON_Database/bookDatabase.json", books());
         //System.out.println("Book ID=" + book.getBookID() + " was added to the Library database.");
    }
    
    public static void removeBook(int bookId)
    {
         if (books().containsKey(bookId)) {
            staffs().remove(bookId);
            serialize("JSON_Database/bookDatabase.json", staffs());  
            System.out.println("Book ID=" + bookId + " was removed from the Library database.");
        } else {
            System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
        }
    }
    
    
    public static void printBookDatabase(Hashtable<Integer, Book> hash)
    {
        Set<Entry<Integer, Book>> entrySet = hash.entrySet();
        
        for(Entry<Integer, Book> entry : entrySet) {
 
            System.out.print("ID=" + entry.getKey() + " " + entry.getValue());
        }
    }
    
    public static void printAccountDatabase(Hashtable<Integer, Account> hash)
    {
        Set<Entry<Integer, Account>> entrySet = hash.entrySet();
        
        for(Entry<Integer, Account> entry : entrySet) {
 
            System.out.print("ID=" + entry.getKey() + " " + entry.getValue());
        }
    }
    
    public static void showLibraryDatabase()
    {
        System.out.println("\nStaffs database:");
        printAccountDatabase(staffs());
        
        System.out.println("\nSuppliers database:");
        printAccountDatabase(suppliers());
        
        System.out.println("\nUsers database:");
        printAccountDatabase(users());
        
        System.out.println("\nBooks database:");
        printBookDatabase(books());
        
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
