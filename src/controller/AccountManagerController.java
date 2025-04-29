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
        };
        throw new Exception("Failed to add account!");
    }

    public boolean login() {
        String username = ValidationAndNormalizingTextUtil.getNonEmptyStringWithoutSpace("Enter username to login: ");
        String password = ValidationAndNormalizingTextUtil.getNonEmptyString("Enter password to login: ");
        String encryptedPassword = ValidationAndNormalizingTextUtil.md5Encrypt(password);
        return accountManager.login(username, encryptedPassword);
    }

    public String getUsername() {
        return accountInputer.getAccount().getUsername();
    }
}
