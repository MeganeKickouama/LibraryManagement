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
public class User extends Account{

    private String firstName;
    private String lastName;
    private boolean isMember;
    
    public User(int accountID, String password, String fname, String lname) 
    {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname;
        this.isMember=false; // by default, users are not members
    }

    public User(int accountID, String password, String fname, String lname, boolean isMember) 
    {
        super(accountID, password);
        this.firstName=fname;
        this.lastName=lname;
        this.isMember=isMember;
    }
    
    //Send request to get membership, then a staff employee will add user as a member
    public void applyForMembership()
    {
        this.isMember = true;
    }
    
     public void borrowBook()
    {
        //Code to borrow a book
    }
    
    //Return a book
    public void returnBook()
    {
        //Code to return a book
    }
    
    // Getter methods
    
    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }
    
    public boolean isMember() 
    {
        return isMember;
    }

    // Setter methods
    
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    
    @Override
    public String toString()
    {
       return String.format("User_ID=%d, Last_Name=%s, First_Name=%s, Is_Member=%b", super.getAccountID(), lastName, firstName, isMember);
    }
   
}
