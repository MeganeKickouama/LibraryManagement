package librarymanagement;

/**
 * @author szakr
 * @author kmega
 * @author hqara
 * @author scol
 */

interface LogIn {

    int AccountLoggedIn();
}

class LogInFactory {

    static public Account createAccountType(int accountId, String password) 
    {
        String accountIdStr = String.valueOf(accountId);
        if (accountIdStr.startsWith("1") && Library.staffs().containsKey(accountId)
                && Library.staffs().get(accountId).getPassword().equals(password)) {
            Account staff = new Staff(accountId, password);
            Library.staffs().put(accountId, staff);
            System.out.println("Staff ID=" + accountId + " logged in successfully");
            return staff;
        } else if (accountIdStr.startsWith("2") && Library.suppliers().containsKey(accountId)
                && Library.suppliers().get(accountId).getPassword().equals(password)) {
            Account supplier = new Supplier(accountId, password);
            Library.suppliers().put(accountId, supplier);
            System.out.println("Supplier ID=" + accountId + " logged in successfully");
            return supplier;
        } else if (accountIdStr.startsWith("3") && Library.users().containsKey(accountId)
                && Library.users().get(accountId).getPassword().equals(password)) {
            Account user = new User(accountId, password);
            Library.users().put(accountId, user);
            System.out.println("User ID=" + accountId + " logged in successfully");
            return user;
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
