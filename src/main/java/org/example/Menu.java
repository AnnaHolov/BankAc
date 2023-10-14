package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static void menu() throws IOException {
        System.out.println("Input number of operation:");
        System.out.println("1-Create Account");
        System.out.println("2-Add money:");
        System.out.println("3-Transfer to another account");
        System.out.println("4-Check balance");
        System.out.println("5-Account information");
        System.out.println("6- Exit program");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        switch (x) {
            case 1:
                Account.createAcc();
                break;
            case 2:
                Account.addMoney();
                break;
            case 3:
                Account.transferMoney();
                break;
            case 4:
                Account.checkBalance();
            case 5:
                Account.accInfo();
            case 6:
                exitProgram();
            default:
                System.out.println("Wrong number");
                break;
        }
    }

    public static void exitProgram() {

            System.exit(0);



    }
    }


