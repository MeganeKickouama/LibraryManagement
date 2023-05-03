package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 

import java.io.*;
import org.json.simple.JSONObject;

/**
 *
 * @author szakr
 */
public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File bookDatabaseFile = new File("../bookDatabase.json");
        LogInFactory loginFact = new LogInFactory();
        Account acc;
        String[] accounts = {
            "123456",
            "134567",
            "223432",
            "213456",
            "245678",
            "345678",
            "398678"
        };
        
        for (String account : accounts) {
            acc = loginFact.createAccountType(account);
            
        }
        //System.out.println("Supplier");
        //System.out.println("Key\t\tAccount ID      Password");
        //System.out.println(Library.supplierDatabase);

        Book test = new Book("Twilight", "Stephanie Meyer", 22);
        Library.serialize(bookDatabaseFile);
        
        Staff staff = new Staff("123435", "password");
        staff.addBook(test);
        
        //Library.reserialize();
    }
    
}
