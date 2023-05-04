package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author szakr
 */
public class Supplier extends Account{
    
    private String supplierName;

    public Supplier(int accountID, String password, String name) 
    {
        super(accountID, password);
        this.supplierName=name;
    }
  
}
