package ui;

import controller.AccountManagerController;
import entity.Account;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author iNJZ
 */
public class J1SP0072MD5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountManagerController controller = new AccountManagerController();
        String menu = """
                      ========= Account Management System =========
                      1. Add Account
                      2. Login
                      3. Exit
                      
                      (Please choose 1 to Add, 2 to Login and 3 to Exit program).
                      Your choice: """;

        while (true) {
            int choice = ValidationAndNormalizingTextUtil.getInt(menu, "Must input an integer number!", "Must input an integer in range [1,3]", 1, 3);
            switch (choice) {
                case 1:
                    try {
                        Account account = controller.addAcount();
                        System.out.println("Account added successfully with ID: " + account.getId());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    if (controller.login()) {
                        System.out.println("Hello " + controller.getUsername());
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    return;

                default:
                    throw new AssertionError();
            }
        }
    }
}
