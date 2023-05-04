package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 

import java.io.*;
import static librarymanagement.Account.searchBook;
import static librarymanagement.Book.nextID;

/**
 *
 * @author szakr
 */
public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //File bookDatabaseFile = new File("../bookDatabase.json");
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
            //acc = loginFact.createAccountType(account);  
        }
        
        //System.out.println("Supplier");
        //System.out.println("Key\t\tAccount ID      Password");
        //System.out.println(Library.supplierDatabase);
                                                                                
        //Book test = new Book("Megane", "Stephanie Meyer", 22);
        //Library.serialize("JSON_Database/bookDatabase.json", Library.bookDatabase);
        
        Staff staff = new Staff(123435, "password", "hibba","qaraman");
        //staff.addBook(test);
        
        //Library.deserialize("JSON_Database/bookDatabase.json", Library.books());
        //System.out.print(Library.books().toString());
        
        //staff.addBook(new Book("TEST", "TEST AUTHOR", 0, 8));
        staff.addBook(new Book(nextID(), "titleA", "authorA",8 ));
        staff.addBook(new Book(nextID(), "titleB", "authorB",9 ));
        System.out.println("\nInside bookDatabase.json after adding two books:\n"
                +Library.books().toString());
        
        System.out.println();
        staff.deleteBook(8); // get(1) should not be null, 
        staff.deleteBook(1);
        System.out.println("\nInside bookDatabase.json after deleting a book:\n"
                + Library.books().toString());
        
        System.out.println("\nSearching for a book:");
        searchBook(1);
        searchBook(2);
        
        System.out.println("\nAdding a member to userDatabase.json:");
        User usertest = new User(321123,"password","sarah","colantani");
        Library.addUser(usertest);
        Staff stafftest = new Staff(12234, "password", "hibba","qaraman");
        Library.addStaff(stafftest);
        usertest.applyForMembership(); 
        stafftest.addMember(usertest);
        System.out.println("\nStaff employee updating user Status from nonMember to Member:\n" 
                + Library.users().toString());

    }
    
}
