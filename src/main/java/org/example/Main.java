package org.example;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        prepareTestData();
        Menu.menu();
    }

    private static void prepareTestData() {
        Account acc1= new Account("John Smith", 100);
        Account acc2 = new Account("Mary Jons", 300);

        Account.storage.put(acc1.accNumber, acc1);
        Account.storage.put(acc2.accNumber, acc2);
    }
}

