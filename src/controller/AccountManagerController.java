/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.AccountInputer;
import bo.AccountManager;
import entity.Account;

/**
 *
 * @author iNJZ
 */
public class AccountManagerController {

    private AccountInputer accountInputer;
    private AccountManager accountManager;

    public AccountManagerController() {
        accountInputer = new AccountInputer();
        accountManager = new AccountManager();
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
        return accountManager.login(credentials[0], credentials[1]);
    }
    
    public String getUsername() {
        return accountInputer.getAccount().getUsername();
    }
}
