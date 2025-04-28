/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iNJZ
 */
public class AccountManager {

    private List<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) throws Exception {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername())) {
                throw new Exception("Username already exists!");
            }
        }

        return accounts.add(account);
    }

    public boolean login(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
