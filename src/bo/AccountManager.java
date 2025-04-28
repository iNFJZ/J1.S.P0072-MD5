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
    private int lastId;

    public AccountManager() {
        accounts = new ArrayList<>();
        lastId = 0;
    }

    public boolean addAccount(Account account) {
        account.setId(++lastId);
        return accounts.add(account);
    }

    public boolean login(String username, String encryptedPassword) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)
                    && account.getPassword().equals(encryptedPassword)) {
                return true;
            }
        }
        return false;
    }
}
