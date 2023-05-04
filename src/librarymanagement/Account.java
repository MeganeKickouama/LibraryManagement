package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author szakr
 */
public class Account {
    
    private String accountID;
    private String password;
   

    public Account(String accountID, String password)
    {
        this.accountID = accountID;
        this.password = password;
    }

    
     public Book searchBook(String bookTitle) 
     {
        // Code to search for a book in the library
        return null;
        // Code to search for a book in the library
     }
    
    public String getAccountID()
    {
        return accountID;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    //Will add getters and setters for all fields later
    @Override
    public String toString() {
        
        return "\t"+accountID+"\t\t"+password+"\n";
    }

}
