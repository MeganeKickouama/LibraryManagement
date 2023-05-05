package librarymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
/**
 *
 * @author szakr
 */
interface LogIn {
    int AccountLoggedIn();
}

class LogInFactory{ 
    
        static public LogIn createAccountType(int accountId, String password) 
        {
            String accountIdStr = String.valueOf(accountId);
            if (accountIdStr.startsWith("1"))  {
                 Account staff = new Staff(accountId, "Abc123", "hibba", "qaraman");
                 Library.staffs().put(accountId, staff);
                 System.out.println("Staff ID="+accountId +" logged in successfully");
                 return new Staff(accountId,password); 
            } else if (accountIdStr.startsWith("2")) {
                Account supplier = new Supplier(accountId, "Def123","Books Inc.");
                Library.suppliers().put(accountId, supplier);
                System.out.println("Supplier ID="+accountId +" logged in successfully");
                return new Supplier(accountId,password);
            } else if (accountIdStr.startsWith("3")) {
                Account user = new User(accountId, "Ghi123", "sadaf", "zakria");
                Library.users().put(accountId, user);
                System.out.println("User Id="+accountId +" logged in successfully");
                return new User(accountId,password);
            }
            return null;
        }
} 

/*
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
*/
