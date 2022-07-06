package service.imp;

import service.verification.ValueCheck;

public class TaskService {

    public static String chooseStatus(){
        ValueCheck valueCheck = new ValueCheck();
        String status;

        while(true) {
            System.out.println("Choose new status:\n1. Planned\n2. In progress\n3. Finished");
            int choice = valueCheck.checkInt();
            if (choice == 1) {
                status = "Planned";
                break;
            } else if (choice == 2) {
                status = "In progress";
                break;
            } else if (choice == 3) {
                status = "Finished";
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        return status;
    }
}
