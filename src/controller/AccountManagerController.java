/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.AccountInputer;
import bo.AccountManager;
import entity.Account;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author iNJZ
 */
public class AccountManagerController {

    private AccountManager accountManager;
    private AccountInputer accountInputer;
    private String currentUsername;

    public AccountManagerController() {
        accountManager = new AccountManager();
        accountInputer = new AccountInputer();
    }

    public Account addAcount() throws Exception {
        Account account = accountInputer.inputInformationAccount();
        if (accountManager.addAccount(account)) {
            return account;
        }
        throw new Exception("Fail to add account!");
    }

    public boolean login() {
        String[] credentials = accountInputer.inputLoginCredentials();
        boolean result = accountManager.login(credentials[0], credentials[1]);
        if (result) {
            currentUsername = credentials[0];
        }
        return result;
    }

    public String getUsername() {
        return currentUsername;
    }
}
