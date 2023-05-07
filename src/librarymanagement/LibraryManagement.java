package librarymanagement;

import java.io.*;
import java.util.*;
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

        Library.deserialize("JSON_Database/staffDatabase.json", Library.staffs());
        Library.deserialize("JSON_Database/supplierDatabase.json", Library.suppliers());
        Library.deserialize("JSON_Database/userDatabase.json", Library.users());
        Library.deserialize("JSON_Database/bookDatabase.json", Library.books());
        
        /*
        // Hardcode Existing Staffs, Suppliers, Users and Books
        //Staffs
        Staff staff1 = new Staff(1111, "staff", "Cornelia", "Chirita");
        Staff staff2 = new Staff(1112, "staff", "Nagat", "Drawel");
        Staff staff3 = new Staff(1113, "staff", "Syed", "Afzal");
        Staff staff4 = new Staff(1114, "staff", "Pejman", "Azadi");
        Staff staff5 = new Staff(1115, "staff", "Mehdi", "Farzad");
        Staff staffs[] = {staff1, staff2, staff3, staff4, staff5};
        for (Staff staffDatabase : staffs) {
            Library.addStaff(staffDatabase);
        };
        System.out.println("Existing staff employees in database:\n" + Library.staffs().toString());

        // Suppliers
        Supplier supplier1 = new Supplier(2221, "supplier", "Hani AbuSharkh");
        Supplier supplier2 = new Supplier(2222, "supplier", "Jakes");
        Supplier supplier3 = new Supplier(2223, "supplier", "Vanier");
        Supplier supplier4 = new Supplier(2224, "supplier", "Dawson");
        Supplier supplier5 = new Supplier(2225, "supplier", "JAC");
        Supplier suppliers[] = {supplier1, supplier2, supplier3, supplier4, supplier5};
        for (Supplier supplierDatabase : suppliers) {
            Library.addSupplier(supplierDatabase);
        };
        System.out.println("Existing suppliers in database:\n" + Library.suppliers().toString());

        // Users
        User user1 = new User(3331, "user", "Hibba", "Qaraman");
        User user2 = new User(3332, "user", "Sarah", "Colantoni");
        User user3 = new User(3333, "user", "Sadaf", "Zakria");
        User user4 = new User(3334, "user", "Mégane", "Kickouama");
        User user5 = new User(3335, "user", "Yu", "Jiang");
        Library.addUser(user1);
        Library.addUser(user2);
        Library.addUser(user3);
        Library.addUser(user4);
        Library.addUser(user5);
        /*
        User users[] = {user1, user2, user3, user4, user5};
        for (User userDatabase : users) {
            Library.addUser(userDatabase);
        };
        System.out.println("Existing users in database:\n" + Library.users().toString());
        */
        
        /*
        // Books
        Book book1 = new Book(nextID(), "Twilight", "Stephanie Meyer", 12.99, 4);
        Book book2 = new Book(nextID(), "1984", "George Orwell", 18.98, 7);
        Book book3 = new Book(nextID(), "Beloved", "Toni Morrison", 13.25, 6);
        Book book4 = new Book(nextID(), "Dune", "Frank Herbert", 7.95, 2);
        Book book5 = new Book(nextID(), "Outliers", "Malcolm Gladwell", 15.25, 1);
        Library.addBook(book1);
        Library.addBook(book2);
        Library.addBook(book3);
        Library.addBook(book4);
        Library.addBook(book5);
        
        /*Book books[] = {book1, book2, book3, book4, book5};
        for (Book bookDatabase : books) {
            Library.addBook(bookDatabase);
        };
        System.out.println("Existing books in database:\n" + Library.books().toString());
        */
        
        Library.showLibraryDatabase();
        
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease enter your account ID and password to login:");
            System.out.print("Account ID: ");
            int enteredID = input.nextInt();
            System.out.print("Password: ");
            String enteredPassword = input.next();

            // Check if the entered credentials are valid
            if (!(Library.staffs().containsKey(enteredID) && Library.staffs().get(enteredID).getPassword().equals(enteredPassword))
                    && !(Library.suppliers().containsKey(enteredID) && Library.suppliers().get(enteredID).getPassword().equals(enteredPassword))
                    && !(Library.users().containsKey(enteredID) && Library.users().get(enteredID).getPassword().equals(enteredPassword))) {
                System.out.println("Invalid username or password. Default IDs for Staff, "
                        + "Supplier, and User account types start with 1, 2, and 3"
                        + "\nrespectively, and the default password for all account types is the lowercase account type name.");
                System.out.print("Would you like to try again? (Y/N): ");
                String choice = input.next();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Exiting program...");
                    return;
                }
                continue;
            }

            LogInFactory loginFact = new LogInFactory();
            Account account = loginFact.createAccountType(enteredID, enteredPassword);
            if (account == null) {
                System.out.println("Invalid account type");
                return;
            }
            LogIn login = (LogIn) account;
            int accountType = login.AccountLoggedIn();
            int menuChoice = 0;

            // STAFF MENU
            if (accountType == 1) {
                do {

                    try {
                        Staff staff = new Staff(enteredID, enteredPassword);
                        System.out.println("\nStaff Menu:\n1. Add a book and save in file\n2. Search for a book"
                                + "\n3. Mark a book as reserved or not reserved\n4. Modify Book information"
                                + "\n5. Lend book to list of users\n6. Add a member\n7. Show Library Database\n8. Exit");
                        System.out.print("Enter your choice: ");
                        menuChoice = input.nextInt();

                        switch (menuChoice) {

                            case 1:
                                // Add a book and save in file
                                System.out.print("Book Name: ");
                                String name = input.next();
                                System.out.print("Author: ");
                                String author = input.next();
                                System.out.print("Price: ");
                                double price = input.nextDouble();
                                System.out.print("Quantity: ");
                                int quantity = input.nextInt();
                                staff.addBook(new Book(nextID(), name, author, price, quantity));
                                break;
                            case 2:
                                // Search for book
                                System.out.print("Enter book ID your looking for: ");
                                staff.searchBook(input.nextInt());
                                break;
                            case 3:
                                // Mark book as reserved or unreserved
                                System.out.print("Book ID: ");
                                int bookid = input.nextInt();
                                if (Library.books().containsKey(bookid)) {
                                    System.out.print("1. Reserve book\n2. Unreserve book\nEnter option:");
                                    switch (input.nextInt()) {
                                        case 1:
                                            staff.markBookReserved(bookid);
                                            break;
                                        case 2:
                                            staff.markBookUnreserved(bookid);
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                } else {
                                    System.out.print("Book ID=" + bookid + " does not exist in the Library database.");
                                }
                                break;
                            case 4:
                                // Modify book info
                                System.out.print("Enter Book ID: ");
                                int bookId = input.nextInt();
                                staff.searchBook(bookId);
                                System.out.print("Enter new Title: ");
                                String newTitle = input.next();
                                System.out.print("Enter new Author: ");
                                String newAuthor = input.next();
                                staff.modifyBook(bookId, newTitle, newAuthor);
                                break;
                            case 5:
                                //Lend book to list of users
                                System.out.print("Book ID: ");
                                bookId = input.nextInt();
                                staff.lendBook(bookId);
                                break;
                            case 6:
                                //Add a member
                                System.out.print("New User ID: ");
                                int userId = input.nextInt();
                                System.out.print("New User Password: ");
                                String password = input.next();
                                System.out.print("New User First Name: ");
                                String fname = input.next();
                                System.out.print("New User Last Name: ");
                                String lname = input.next();
                                staff.addMember(new User(userId, password, fname, lname));
                                break;
                            case 7:
                                // Show updated library database
                                Library.showLibraryDatabase();
                                break;
                            case 8:
                                // Exit program
                                System.out.println("Exiting program...");
                                menuChoice = 8;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input, please try again");
                        input.nextLine();
                        menuChoice = -1;

                    }

                } while (menuChoice != 8);
                
            //SUPPLIER MENU
            } else if (accountType == 2) {
                do {
                    try {
                        Supplier supplier = new Supplier(enteredID, enteredPassword);
                        System.out.println("\nSupplier Menu:\n1. Search for a book\n2. Sell a book\n3. Show Library Database\n4. Exit");
                        System.out.print("Enter your choice: ");
                        menuChoice = input.nextInt();

                        switch (menuChoice) {

                            case 1:
                                // Search for a book
                                System.out.print("Enter book ID your looking for: ");
                                int bookID = input.nextInt();
                                supplier.searchBook(bookID);
                                break;
                            case 2:
                                // Sell a book
                                System.out.print("Enter Book ID: ");
                                int bookId = input.nextInt();
                                System.out.print("Enter Quantity: ");
                                int quantity = input.nextInt();
                                System.out.print("Enter Price: $");
                                double price = input.nextDouble();
                                supplier.sellBook(bookId, quantity, price);
                                break;
                            case 3:
                                // Show updated library database 
                                Library.showLibraryDatabase();
                                break;
                            case 4:
                                // Exit program
                                System.out.println("Exiting program...");
                                menuChoice = 4;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input, please try again");
                        input.nextLine();
                        menuChoice = -1;

                    }

                } while (menuChoice != 4);
            
            // USER MENU
            } else if (accountType == 3) {
                do {
                    try {
                        User user = new User(enteredID, enteredPassword);
                        System.out.println("\nUser Menu:\n1. Search for a book\n2. Apply for membership\n3. Borrow a book"
                                + "\n4. Return a book\n5. Show Library Database\n6. Exit");
                        System.out.print("Enter your choice: ");
                        menuChoice = input.nextInt();

                        switch (menuChoice) {

                            case 1:
                                // Search for a book
                                System.out.print("Enter book ID your looking for: ");
                                int bookid = input.nextInt();
                                user.searchBook(bookid);
                                break;
                            case 2:
                                // Apply for membership
                                System.out.print("Enter your ID: ");
                                int userid = input.nextInt();
                                if (userid == enteredID) {
                                    user.applyForMembership(userid);
                                } else {
                                    System.out.print("Incorrect User ID: Registration failed.");
                                }
                                break;
                            case 3:
                                // Borrow a book
                                System.out.print("Book ID: ");
                                bookid = input.nextInt();
                                user.borrowBook(bookid);
                                break;
                            case 4:
                                // Return a book
                                System.out.print("Book ID: ");
                                bookid = input.nextInt();
                                user.returnBook(bookid);
                                break;
                            case 5:
                                Library.showLibraryDatabase();
                                break;
                            case 6:
                                // Exit the program
                                System.out.println("Exiting program...");
                                menuChoice = 6;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input, please try again");
                        input.nextLine();
                        menuChoice = -1;

                    }

                } while (menuChoice != 6);
            }

        }

    }

}
