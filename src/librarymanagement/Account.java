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
public abstract class Account {
    
    private int accountID;
    private String password;
   
    public Account(int accountID, String password)
    {
        this.accountID = accountID;
        this.password = password;
    }

    // this method is abstract because anyone can browse the library database
    public abstract void searchBook(int bookId);

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
