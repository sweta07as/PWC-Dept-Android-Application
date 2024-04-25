package com.example.javalib;

import java.util.Scanner;

public class JavaLastChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome");
        System.out.println("Choose one option: \n 1.\tManage contacts\n 2.\tMessages\n 3.\tQuit");
        int num = sc.nextInt();

        switch (num){
            case 1:{
                System.out.println("Choose one option: \n 1.\tShow all contacts\n 2.\tAdd a new contact\n 3.\tSearch for a contact\n 4.\tGo back to previous menu");
                int contactOption = sc.nextInt();
                break;
            }

            case 2:{
                System.out.println("Choose one option: \n 1.\tSee the list of all messages\n 2.\tSend a new message\n 3.\tGo back to previous menu");
                int messageOption = sc.nextInt();
                break;
            }

            case 3:{
                break;
            }
        }
    }
}

