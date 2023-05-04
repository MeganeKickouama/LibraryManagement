package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author szakr
 * @author hqara
 */
public class Account {
    
    private String accountID;
    private String password;
   

    public Account(String accountID, String password)
    {
        this.accountID = accountID;
        this.password = password;
    }

    public static void searchBook(int bookId) {
    for (Book book : Library.books().values()) {
        if (book.getBookID() == bookId) {
            System.out.println("Book ID="+bookId+"("+book.getTitle()+") is available in the Library.");
            return;
        }
    }
    System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
    }

    // Getter methods
    public String getAccountID() {
        return accountID;
    }
    
      public String getPassword() {
        return password;
    }
 
    // Setter methods
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "\t"+accountID+"\t\t"+password+"\n";
    }

}
