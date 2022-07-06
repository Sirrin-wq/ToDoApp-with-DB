package service.imp;

import entity.Task;
import repository.database.DatabaseOperations;
import service.Operations;
import service.verification.ValueCheck;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskOperationsImp implements Operations {

    DatabaseOperations databaseOperations = new DatabaseOperations();
    ValueCheck valueCheck = new ValueCheck();
    Scanner scan = new Scanner(System.in);

    @Override
    public void addTask() {

        System.out.println("Enter name of the task");
        String name = valueCheck.checkString();

        System.out.println("Enter description of the task");
        String description = valueCheck.checkString();

        String status = TaskService.chooseStatus();

        databaseOperations.addTask(new Task(name, description, status));
        System.out.println("Task has been added");
    }

    @Override
    public void updateTask() {
        System.out.println("Enter name of the task you want to update");
        String inputName = valueCheck.checkString();

        while (true) {
            System.out.println("1. Change name\n2. Change description\n3. Change status\n4. Change all");
            int pick = valueCheck.checkInt();
            if (pick >= 1 && pick <= 4) {
                databaseOperations.updateTask(inputName, pick);
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        System.out.println("Task has been updated");
    }

    @Override
    public void removeTask() {
        while(true) {
            System.out.println("1. Remove certain task\n2. Remove all tasks");
            int pick = valueCheck.checkInt();

            if (pick == 1) {
                System.out.println("Enter name of the task you want ot remove");
                valueCheck.checkString();
                String inputName = valueCheck.checkString();
                databaseOperations.removeTask(inputName);
                System.out.println("Task has been removed");
                break;
            } else if (pick == 2) {
                while (true) {
                    System.out.println("Are you sure you want to delete all tasks?\n1. Yes\n2. No");
                    int confirm = valueCheck.checkInt();

                    if (confirm == 1) {
                        databaseOperations.removeAllTasks();
                        break;
                    } else if (confirm == 2) {
                        //back to menu
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }
                } break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    @Override
    public void showTask() {
        while(true) {
            System.out.println("1. Show task by name\n2. Show all tasks");
            int pick = valueCheck.checkInt();

            if (pick == 1) {
                System.out.println("Enter name of the task you want to see");
                valueCheck.checkString();
                String inputName = valueCheck.checkString();
                databaseOperations.showTask(inputName);
                break;
            } else if (pick == 2) {
                databaseOperations.showAllTasks();
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

}
