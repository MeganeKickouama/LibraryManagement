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
    
    private int accountID;
    private String password;
   

    public Account(int accountID, String password)
    {
        this.accountID = accountID;
        this.password = password;
    }

    // this method is static because anyone can browse the library database
    public static void searchBook(int bookId) 
    {
        if (Library.books().containsKey(bookId)) {
           Book book = Library.books().get(bookId);
           System.out.println("Book ID="+bookId+"("+book.getTitle()+") is available in the Library.");
            return;
        }
        System.out.println("Book ID=" + bookId + " does not exist in the Library database.");
    }

    // Getter methods
    
    public int getAccountID()  
    {
        return accountID;
    }
    
    public String getPassword() 
    {
        return password;
    }
 
    // Setter methods
    
    public void setAccountID(int accountID) 
    {
        this.accountID = accountID;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    @Override
    public String toString() 
    {
        return "\t"+accountID+"\t\t"+password+"\n";
    }

}
