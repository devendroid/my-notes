package com.dev.playground.solid.srp;

/*
Single Responsibility Principle:
A class should have one and only one reason to change,
means every Java class must perform a single functionality.
*/

//===BEFORE==============================

/*
Here BankServicex class doing multiple jobs that should not do as per the SRP
*/
class BankServicex {

    boolean openAccount() {
        return false;
    }

    boolean closeAccount(String accountNumber) {
        return false;
    }

    boolean deposit(double amount, String accountNumber) {
        return false;
    }

    double withDraw(String accountNumber) {
        return 0;
    }

    void printPassbook() {
    }

    void sendNotification(String medium) {
    }

    void getLoanInterestInfo(String loanType) {
    }

}

//==With SRP==============================

class BankService {

    boolean openAccount() {
        return false;
    }

    boolean closeAccount(String accountNumber) {
        return false;
    }
}

class AccountService {

    boolean deposit(double amount, String accountNumber) {
        return false;
    }

    double withDraw(String accountNumber) {
        return 0;
    }
}

class PrinterService {

    void printPassbook() {
    }
}

class NotificationService {

    void sendNotification(String medium) {
    }
}

class LoanService {

    void getLoanInterestInfo(String loanType) {
    }
}

//==============
public class SingleResponsibilityEx1 {
    public static void main(String[] arr) {

    }
}
