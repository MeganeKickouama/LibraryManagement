package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
/**
 *
 * @author szakr
 */
public abstract class LogIn {
    abstract void AccountLoggedIn();
}
class LogInFactory{
    static public Account createAccountType(String AccountId){
        if(AccountId.startsWith("1")){
            //System.out.println("New Staff");
            Account s = new Staff(AccountId, "Abc123");
            Library.staffDatabase.put(Integer.parseInt(AccountId), s);
            return s;
        }
        else if(AccountId.startsWith("2")){
            //System.out.println("New Supplier");
            Account sup = new Supplier(AccountId, "Def123");
            Library.supplierDatabase.put(Integer.parseInt(AccountId), sup);
            return sup;
        }
        else if(AccountId.startsWith("3")){
            //System.out.println("New User");
            Account user = new User(AccountId, "Ghi123");
            Library.userDatabase.put(Integer.parseInt(AccountId), user);
            return user;
        }
        return null;
        
    } 
} 
