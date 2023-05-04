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
    
        static public Account createAccountType(int accountId) 
        {
            String accountIdStr = String.valueOf(accountId);
            if (accountIdStr.startsWith("1"))  {
                 Account s = new Staff(accountId, "Abc123", "hibba", "qaraman");
                 Library.staffs().put(accountId, s);
                 return s; 
            } else if (accountIdStr.startsWith("2")) {
                Account sup = new Supplier(accountId, "Def123","Books Inc.");
                Library.suppliers().put(accountId, sup);
                return sup;
            } else if (accountIdStr.startsWith("3")) {
                Account user = new User(accountId, "Ghi123", "sadaf", "zakria");
                Library.users().put(accountId, user);
                return user;
            }
            return null;
        }
} 
