package com.vin.bankservice.service;

import com.vin.bankservice.domain.BankAccount;
import com.vin.bankservice.exception.InvalidAmountException;

import java.util.List;
public interface BankService {

    void createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw1(Long acNum, double amt) throws InvalidAmountException;


    double deposit(Long acNum, double amt) throws InvalidAmountException;

    int Transaction(Long srcAc, Long dstAc, double amt) throws InvalidAmountException;

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);
}