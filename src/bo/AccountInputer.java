/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Account;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author iNJZ
 */
public class AccountInputer {

    private Account account;

    public Account getAccount() {
        return account;
    }

    public Account inputInformationAccount() {
        account = new Account();
        String username = ValidationAndNormalizingTextUtil.getNonEmptyString("Enter username: ");
        account.setUsername(username);
        String password = ValidationAndNormalizingTextUtil.getNonEmptyString("Enter password: ");
        account.setPassword(ValidationAndNormalizingTextUtil.md5Encrypt(password));
        account.setName(ValidationAndNormalizingTextUtil.getStringByRegex("Enter name: ", "Please enter character only!", "[A-Za-z ]+"));
        account.setPhone(ValidationAndNormalizingTextUtil.getPhone(10, "Enter phone number: "));
        String email = ValidationAndNormalizingTextUtil.getEmail("Enter email: ");
        account.setEmail(email);
        account.setAddress(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter address: "));
        account.setDateOfBirth(ValidationAndNormalizingTextUtil.getDate("Enter date (dd/MM/yyyy): "));

        return account;
    }

}
