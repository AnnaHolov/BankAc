package org.example;

import java.io.IOException;
import java.util.*;

public class Account {
    static HashMap<Integer, Account> storage = new HashMap<>();
    String ownerName;
    int balance;
    int accNumber;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(String ownerName, int balance) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.accNumber = generateAccNumber();
    }

    public static int generateAccNumber() {
        Random random = new Random();
        return random.ints(1, 10000)
                .findFirst()
                .getAsInt();
    }

    public static void createAcc() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String ownerName = sc.next();

        System.out.println("Enter a start balance: ");
        int balance = sc.nextInt();

        Account acc = new Account(ownerName, balance);

        System.out.println("Account number: " + acc.accNumber);
        System.out.println("Account name: " + acc.ownerName);
        System.out.println("Account balance:  " + acc.balance);

        storage.put(acc.accNumber, acc);
        Menu.menu();

    }

    public static void addMoney() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an account number: ");
        int accNumber = sc.nextInt();
        System.out.println("Enter a sum you want to add: ");
        int added = sc.nextInt();
       Account acc = storage.get(accNumber);
       int sum = acc.balance+added;
       acc.setBalance(sum);
       System.out.println("Sum added: "+sum);
        Menu.menu();



    }

    public static void transferMoney() throws IOException {
        Set<Integer> accNumbers = storage.keySet();
        System.out.println(accNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your source account number for transfer: ");
        int accNumber = sc.nextInt();
        Account sourceAcc = storage.get(accNumber);
        System.out.println("Enter sum you want to transfer: ");
        int sum = sc.nextInt();
        System.out.println("Choose your receiver account number for transfer: ");
        int accNumber1 = sc.nextInt();
        Account receiverAcc = storage.get(accNumber1);
        sourceAcc.balance= sourceAcc.balance-sum;
        receiverAcc.balance= receiverAcc.balance+sum;
        System.out.println("Receiver account balance: "+ receiverAcc.balance);
        Menu.menu();



    }

    public static void checkBalance() throws IOException {
        Set<Integer> accNumbers = storage.keySet();
        System.out.println(accNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your account number: ");
        int accNumber = sc.nextInt();
        Account currentAcc = storage.get(accNumber);
        System.out.println("Owner balance: " + currentAcc.balance);
        Menu.menu();

    }

    public static void accInfo() throws IOException {
        Set<Integer> accNumbers = storage.keySet();
        System.out.println(accNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your account number: ");
        int accNumber = sc.nextInt();
        Account currentAcc = storage.get(accNumber);
        System.out.println("Account number: " + currentAcc.accNumber);
        System.out.println("Owner name: " + currentAcc.ownerName);
        System.out.println("Owner balance: " + currentAcc.balance);
        Menu.menu();

    }
}

