package StudentCollection;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentCollection studentCollection = new StudentCollection();
        int studentId;

        //show menu
        showMenu ();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentCollection.add();
                    break;
                case "2":
                    studentId = studentCollection.inputId();
                    studentCollection.edit(studentId);
                    break;
                case "3":
                    studentId = studentCollection.inputId();
                    studentCollection.delete(studentId);
                    break;
                case "4":
                    studentCollection.sortStudentbyGPA();
                    break;
                case "5":
                    studentCollection.sortStudentByName();
                    break;
                case "6":
                    studentCollection.show();
                    break;
                case "0":
                    System.out.println("Exit!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action below the menu: ");
                    break;
                }
                if (exit) {
                    break;
                }
                // show menu
                showMenu();
        }
    }

    /**
     * Create Menu
     */

    public static void showMenu() {
        System.out.println("==========Menu==========");
        System.out.println("1. Add Student.");
        System.out.println("2. Edit student by Id.");
        System.out.println("3. Delete student by Id.");
        System.out.println("4. Sort student by GPA.");
        System.out.println("5. Sort student by Name.");
        System.out.println("6. Show student.");
        System.out.println("0. Exit.");
        System.out.println("========================");
        System.out.println("Please select: ");
    }
}
