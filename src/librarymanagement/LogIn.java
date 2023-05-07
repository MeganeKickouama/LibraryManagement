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
        if (accountIdStr.startsWith("1") ) {
            Account staff = new Staff(accountId, password);
            System.out.println("Staff ID=" + accountId + " logged in successfully");
            return staff;
        } else if (accountIdStr.startsWith("2")) {
            Account supplier = new Supplier(accountId, password);
            System.out.println("Supplier ID=" + accountId + " logged in successfully");
            return supplier;
        } else if (accountIdStr.startsWith("3")) {
            Account user = new User(accountId, password);
            System.out.println("User ID=" + accountId + " logged in successfully");
            return user;
        }
        return null;
    }
}
