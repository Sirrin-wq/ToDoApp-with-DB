package service.verification;

import java.util.Scanner;

public class ValueCheck {

    private final Scanner scan = new Scanner(System.in);

    public int checkInt() {

        while (!scan.hasNextInt()) {
            System.out.println("Invalid input");
            scan.nextInt();
        }
        return scan.nextInt();
    }

    public String checkString() {

        while (!scan.hasNext()) {
            System.out.println("Invalid input");
            scan.nextLine();
        }
        return scan.nextLine();
    }
}
