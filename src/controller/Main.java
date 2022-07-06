package controller;

import repository.database.DatabaseOperations;
import service.imp.TaskOperationsImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseOperations r = new DatabaseOperations();
        TaskOperationsImp o = new TaskOperationsImp();

//        o.removeTask();

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Integer");
//        int first = scan.nextInt();
//        System.out.println("String");
//        scan.nextLine();
//        String second = scan.nextLine();
//
//        System.out.println("\n"+first + " " + second);
//        o.showTask();

        o.addTask();
        o.addTask();
    }
}
