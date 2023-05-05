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
        Staff staff1 = new Staff(1111, "staff", "Cornelia", "Chirita");
        Staff staff2 = new Staff(1112, "staff", "Nagat", "Drawel");
        Staff staff3 = new Staff(1113, "staff", "Syed", "Afzal");
        Staff staff4 = new Staff(1114, "staff", "Pejman", "Azadi");
        Staff staff5 = new Staff(1115, "staff", "Mehdi", "Farzad");

        Staff staffs[] = {staff1, staff2, staff3, staff4, staff5};
        for (Staff staffDatabase : staffs) 
        {
            Library.addStaff(staffDatabase);
        };
        
        System.out.println("Existing staff employees in database:\n"+Library.staffs().toString());

        // Suppliers
        Supplier supplier1 = new Supplier(2221, "supplier", "Hani AbuSharkh");
        Supplier supplier2 = new Supplier(2222, "supplier", "Jakes");
        Supplier supplier3 = new Supplier(2223, "supplier", "Vanier");
        Supplier supplier4 = new Supplier(2224, "supplier", "Dawson");
        Supplier supplier5 = new Supplier(2225, "supplier", "JAC");
        
        Supplier suppliers[] = {supplier1, supplier2, supplier3, supplier4, supplier5};
        for (Supplier supplierDatabase : suppliers) 
        {
            Library.addSupplier(supplierDatabase);
        };

        System.out.println("Existing suppliers in database:\n"+Library.suppliers().toString());

        // Users
        User user1 = new User(3331, "user", "Hibba", "Qaraman");
        User user2 = new User(3332, "user", "Sarah", "Colantoni");
        User user3 = new User(3333, "user", "Sadaf", "Zakria");
        User user4 = new User(3334, "user", "Mégane", "Kickouama");
        User user5 = new User(3335, "user", "Yu", "Jiang");

        User users[] = {user1, user2, user3, user4, user5};
        for (User userDatabase : users) 
        {
            Library.addUser(userDatabase);
        };
        System.out.println("Existing users in database:\n"+Library.users().toString());

        // Hardcode Books for Library
        Book book1 = new Book(nextID(), "Twilight", "Stephanie Meyer", 12.99, 4);
        Book book2 = new Book(nextID(), "1984", "George Orwell", 18.98, 7);
        Book book3 = new Book(nextID(), "Beloved", "Toni Morrison", 13.25, 6);
        Book book4 = new Book(nextID(), "Dune", "Frank Herbert", 7.95, 2);
        Book book5 = new Book(nextID(), "Outliers", "Malcolm Gladwell", 15.25, 1);

        Book books[] = {book1, book2, book3, book4, book5};
        for (Book bookDatabase : books) 
        {
            Library.addBook(bookDatabase);
        };
        System.out.println("Existing books in database:\n"+Library.books().toString());
        
        
        Scanner input = new Scanner(System.in);
  
        
        
        
        
        
        // Ask the user to enter their login credentials
        System.out.println("\nPlease enter your account ID and password to login:");
              
        
        System.out.print("Account ID: ");
        int enteredID = input.nextInt();
        System.out.print("Password: ");
        String enteredPassword = input.next();

        // Check if the entered credentials are valid
        if (!(Library.staffs().containsKey(enteredID) && Library.staffs().get(enteredID).getPassword().equals(enteredPassword))
                && !(Library.suppliers().containsKey(enteredID) && Library.suppliers().get(enteredID).getPassword().equals(enteredPassword))
                && !(Library.users().containsKey(enteredID) && Library.users().get(enteredID).getPassword().equals(enteredPassword))) {
            System.out.println("Invalid username or password. Exiting program...");
            return;
        }

        LogInFactory loginFact = new LogInFactory();
        Account account = loginFact.createAccountType(enteredID, enteredPassword);
        if (account == null) {
            System.out.println("Invalid account type");
            return;
        }
        LogIn login = (LogIn) account;
        int mainChoice = login.AccountLoggedIn();
        int subChoice = 0;
        
        if (mainChoice == 1){
            do {
                Staff staff = new Staff(enteredID, enteredPassword);
                System.out.println("\nStaff Menu:\n1. Add a book and save in file\n2. Search for a book"+
                        "\n3. Mark a book as reserved or not reserved\n4. Modify Book information+"+
                        "\n5. Lend book to list of users\n6. Add a member\n7. Exit");
                System.out.print("Enter your choice: ");
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        //add book + save in file
                        System.out.println("Book name: ");
                        String name = input.next();
                        System.out.println("Author: ");
                        String author = input.next();
                        System.out.println("Price: ");
                        double price = input.nextDouble();
                        System.out.println("Quantity: ");
                        int quantity = input.nextInt();
                        
                        //new Book(nextID(), name, author, price, quantity);
                        staff.addBook(new Book(nextID(), name, author, price, quantity));
                        break;
                    case 2:
                        // search for book
                        System.out.println("Book ID: ");
                        staff.searchBook(input.nextInt());
                        
                        break;
                    case 3:
                        // reserve/not reserve book
                        System.out.println("Book ID: ");
                        //staff.searchBook(input.nextInt());
                        int bookid = input.nextInt();
                        if (Library.books().containsKey(bookid)){
                            System.out.println("1. Reserve book \n 2. Unreserve book");
                            switch (input.nextInt()) {
                                case 1:
                                    
                                        Book bookReserve = Library.books().get(bookid);
                                        staff.markBookReserved(bookReserve);
                                    
                                   
                                    break;
                                    
                                case 2:
                                    
                                        Book bookUnreserve = Library.books().get(bookid);
                                        staff.markBookUnreserved(bookUnreserve);
                                    
                                   
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                        else{
                            System.out.println("This Book ID does not exist in our library.");
                        }
                        break;
                    case 4:
                        // modify book info
                        System.out.println("Enter Book ID: ");
                        int bookId = input.nextInt();
                        if (Library.books().containsKey(bookId)){
                            //Before mods
                            System.out.println(Library.books().get(bookId).toString());
                            
                            System.out.println("Enter new Title: ");
                            String newTitle = input.next();
                            System.out.println("Enter new Author");
                            String newAuthor = input.next();
                            
                            staff.modifyBook(bookId, newTitle, newAuthor);
                        }
                        else{
                            System.out.println("Book can not be modified, does not exist.");
                        }
                        break;
                    case 5:
                        //Lend book to list of users
                        
                        break;
                    case 6:
                        //Add a member
                        System.out.println("Enter User ID: ");
                        int userID = input.nextInt();
                        
                        //User userMember = 
                        
                        //staff.addMember(userMember);
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
                Supplier supplier = new Supplier(enteredID, enteredPassword);
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
                User user = new User(enteredID, enteredPassword);
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
