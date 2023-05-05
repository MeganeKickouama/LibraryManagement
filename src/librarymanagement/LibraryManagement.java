package librarymanagement;

import java.io.*;
import java.util.Scanner;
//import static librarymanagement.Library;
import static librarymanagement.Book.nextID;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String[] args) {
        
            
        // Hardcode Existing Users, Staffs and Suppliers
        
        //Staffs
        Staff staff1 = new Staff(1111, "staff", "Cornelia", "Christie");
        Staff staff2 = new Staff(1112, "staff", "Tyler", "Davis");
        Staff staff3 = new Staff(1113, "staff", "Syed", "Aszaf");
        Staff staff4 = new Staff(1114, "staff", "Pejman", "Azadi");
        Staff staff5 = new Staff(1115, "staff", "Mehdi", "Azazi");

        Staff staffs[] = {staff1, staff2, staff3, staff4, staff5};
        for (Staff staffDatabase : staffs) 
        {
            Library.addStaff(staffDatabase);
        };
        
        System.out.println("Existing staff employees in database:\n"+Library.staffs().toString());

        // Suppliers
        Supplier supplier1 = new Supplier(2111, "supplier", "Hani");
        Supplier supplier2 = new Supplier(2112, "supplier", "Jakes");
        Supplier supplier3 = new Supplier(2113, "supplier", "Vanier");
        Supplier supplier4 = new Supplier(2114, "supplier", "Dawson");
        Supplier supplier5 = new Supplier(2115, "supplier", "JAC");
        
        Supplier suppliers[] = {supplier1, supplier2, supplier3, supplier4, supplier5};
        for (Supplier supplierDatabase : suppliers) 
        {
            Library.addSupplier(supplierDatabase);
        };

        System.out.println("Existing suppliers in database:\n"+Library.suppliers().toString());

        // Users
        User user1 = new User(3111, "user", "Hibba", "Qaraman");
        User user2 = new User(3112, "user", "Sarah", "Colantoni");
        User user3 = new User(3113, "user", "Sadaf", "Zakria");
        User user4 = new User(3114, "user", "Mégane", "Kickouama");
        User user5 = new User(3115, "user", "Yu", "Jiang");

        User users[] = {user1, user2, user3, user4, user5};
        for (User userDatabase : users) 
        {
            Library.addUser(userDatabase);
        };
        System.out.println("Existing users in database:\n"+Library.users().toString());

        // Hardcode Books for Library
        Book book1 = new Book(nextID(), "Twilight", "Stephanie Meyer", 12, 4);
        Book book2 = new Book(nextID(), "1984", "George Orwell", 20, 7);
        Book book3 = new Book(nextID(), "Beloved", "Toni Morrison", 13, 6);
        Book book4 = new Book(nextID(), "Dune", "Frank Herbert", 7, 2);
        Book book5 = new Book(nextID(), "Outliers", "Malcolm Gladwell", 15, 1);

        Book books[] = {book1, book2, book3, book4};
        for (Book bookDatabase : books) 
        {
            Library.addBook(bookDatabase);
        };
        System.out.println("Existing books in database:\n"+Library.books().toString());
        
        
        Scanner input = new Scanner(System.in);
  
        int id= 2234; //change first digit to either 1,2,3 to test all menu
        String password= "temp";
        
        // Ask the user to enter their login credentials
        System.out.println("\nPlease enter your account ID and password to login:");
        System.out.print("Account ID: ");
        int enteredID = input.nextInt();
        System.out.print("Password: ");
        String enteredPassword = input.next();

        // Check if the entered credentials are valid
        if (!(enteredID == id) || !enteredPassword.equals(password)) {
            System.out.println("Invalid username or password. Exiting program...");
            return;
        }
        
        LogInFactory loginFact = new LogInFactory();
        LogIn login = loginFact.createAccountType(id, password);
        int mainChoice = login.AccountLoggedIn();
        int subChoice = 0;

        if (mainChoice == 1){
            do {
                Staff staff = new Staff(id, password);
                System.out.println("\nStaff Menu:\n1. Add a book and save in file\n2. Search for a book"+
                        "\n3. Mark a book as reserved or not reserved\n4. Modify Book information+"+
                        "\n5. Lend book to list of users\n6. Add a member\n7. Exit");
                System.out.print("Enter your choice: ");
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        //Sys
                        //staff.addBook(book);
                        break;
                    case 2:
                        // Code for Sub-menu 2
                        break;
                    case 3:
                        // Code for Sub-menu 3
                        break;
                    case 4:
                        // Code for Sub-menu 3
                        break;
                    case 5:
                        // Code for Sub-menu 3
                        break;
                    case 6:
                        // Code for Sub-menu 3
                        break;
                    case 7:
                        System.out.println("Exiting program...");
                        subChoice = 7;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (subChoice != 7);
        }
        
        else if (mainChoice == 2){
            do {
                Supplier supplier = new Supplier(id, password);
                System.out.println("\nSupplier Menu:\n1. Search for a book\n2. Sell a book\n3. Exit");
                System.out.print("Enter your choice: ");
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        // Code for Sub-menu 1
                        System.out.println("Enter book ID your looking for: ");
                        int bookID = input.nextInt();
                        supplier.searchBook(bookID);
                        break;
                    case 2:
                        // Code for Sub-menu 2
                        break;
                    case 3:
                        System.out.println("Exiting program...");
                        subChoice = 3;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (subChoice != 3);
        }
        
        else if (mainChoice == 3){
            do {
                User user = new User(id, password);
                System.out.println("\nUser Menu:\n1. Search for a book\n2. Apply for membership\n3. Borrow a book"+
                        "\n4. Return a book\n5. Exit");
                System.out.print("Enter your choice: ");
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        // Code for Sub-menu 1
                        break;
                    case 2:
                        // Code for Sub-menu 2
                        break;
                    case 3:
                        // Code for Sub-menu 3
                        break;
                    case 4:
                        // Code for Sub-menu 4
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        subChoice = 5;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (subChoice != 5);
        }

             
        /*
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

        String pass = "passtemp";
        for (String account : accounts) {
            int accountId = Integer.parseInt(account);
            acc = loginFact.createAccountType(accountId, pass);  
        }
        */
        
        /*
        Staff staff = new Staff(123435, "password", "hibba","qaraman");
        staff.addBook(new Book(nextID(), "titleA", "authorA",8, 4 ));
        staff.addBook(new Book(nextID(), "titleB", "authorB",9, 3 ));
        System.out.println("Inside bookDatabase.json after adding two books:\n"
                +Library.books().toString());
        
         staff.modifyBook(2, "Twilight", "Stephanie Meyer");
         System.out.println("Inside bookDatabase.json after modifying a book:\n"
                +Library.books().toString());
        Book sample = new Book(nextID(),"Twilight", "Stephanie Meyer",10, 7);
        Book sample = new Book(nextID(),"Nine Cats","Feverland",10, 7);
        staff.markBookReserved(sample);
         System.out.println("\nInside bookDatabase.json after an staff employee marked a book as reserved:\n"
                +Library.books().toString());
         
        System.out.println();
        staff.deleteBook(8); // get(1) should not be null, 
        staff.deleteBook(1);
        System.out.println("\nInside bookDatabase.json after deleting a book:\n"
                + Library.books().toString());
        
        System.out.println("\nSearching for a book:");
        staff.searchBook(1);
        staff.searchBook(2);
        
        System.out.println("\nAdding a non member user to userDatabase.json:");
        User usertest = new User(321123,"password","sarah","colantani");
        Library.addUser(usertest);
        System.out.println(Library.users().toString());;
        
        System.out.println("\nAdding a staff employee to staffDatabase.json:");
        Staff stafftest = new Staff(12234, "password", "hibba","qaraman");
        Library.addStaff(stafftest);
        System.out.println(Library.staffs().toString());
        
        usertest.applyForMembership(); 
        stafftest.addMember(usertest);
        System.out.println("\nStaff employee updating user Status from nonMember to Member:\n" 
                + Library.users().toString());
        
        System.out.println("");
        
        System.out.println("Borrow Book Test"); //Sarah testing
        usertest.borrowBook(2, "hibba");
        System.out.println("Inside bookDatabase.json after hibba borrowed Book ID=2:\n"
                +Library.books().toString());
        
        usertest.borrowBook(2, "sarah");
        usertest.borrowBook(1, "megane");
        
        System.out.println("");
        
        System.out.println("Return Book Test"); //Sarah testing
        usertest.returnBook(2, "hibba");
        System.out.println("Inside bookDatabase.json after hibba returned Book ID=2:\n"
                +Library.books().toString());
        usertest.returnBook(2, "sarah");
        usertest.borrowBook(2, "sarah");
        usertest.returnBook(1, "megane");
        
        System.out.println("\nAdding a supplier to supplierDatabase.json:");
        Supplier suppliertest = new Supplier(1001, "password", "hani");
        Library.addSupplier(suppliertest);
        System.out.println(Library.suppliers().toString());
        
        System.out.println("");
        
        System.out.println("Sell Book Test"); //Sarah testing
        suppliertest.sellBook(2, 2, 10);
        System.out.println("Check book quantity");
        System.out.println(Library.books().toString());
        System.out.println("Check supplier balance");
        System.out.println(Library.suppliers().toString());
        
        //Won't work because quantity is over book quantity
        suppliertest.sellBook(3, 10, 10);
        */
    }
    
}
