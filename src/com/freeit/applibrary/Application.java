package src.com.freeit.applibrary;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {

        DbCommands command = new DbCommands();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        boolean attribute = true;
        while (attribute) {

            System.out.println("MENU:");
            System.out.println("1 Show book catalog.");
            System.out.println("2 Add book.");
            System.out.println("3 Delete book.");
            System.out.println("4 Update book.");
            System.out.println("5 Quit.");
            System.out.println("Choose number option");

            switch (option) {
                case "1":
                    command.getAllBooks();
                    break;
                case "2":
                    command.addBooks();
                    break;
                case "3":
                    command.deleteBooks();
                    break;
                case "4":
                    command.updateBooks();
                    break;
                case "5":
                    scanner.close();
                    attribute = false;
                    return;
                default:
                    System.out.println("choose your variant");
            }
        }
    }
}



