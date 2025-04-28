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
    private String currentUsername;

    public AccountManagerController() {
        accountInputer = new AccountInputer();
        accountManager = new AccountManager();
    }

    public boolean hasSpaces(String text) {
        return text != null && text.contains(" ");
    }

    public Account addAcount() throws Exception {
        Account account = accountInputer.inputInformationAccount();

        if (hasSpaces(account.getUsername())) {
            throw new Exception("Username cannot contain spaces!");
        }
        if (hasSpaces(account.getEmail())) {
            throw new Exception("Email cannot contain spaces!");
        }
        if (hasSpaces(account.getPhone())) {
            throw new Exception("Phone cannot contain spaces!");

        }
        if (accountManager.addAccount(account)) {
            return account;
        };
        throw new Exception("Email cannot contain spaces!");

    }

    public boolean login() {
        String username = ValidationAndNormalizingTextUtil.getNonEmptyString("Enter username to login: ");
        String password = ValidationAndNormalizingTextUtil.getNonEmptyString("Enter password to login: ");
        String encryptedPassword = ValidationAndNormalizingTextUtil.md5Encrypt(password);
        return accountManager.login(username, encryptedPassword);
    }

    public String getUsername() {
        return currentUsername;
    }
}
