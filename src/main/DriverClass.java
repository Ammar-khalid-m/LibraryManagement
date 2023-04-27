package src.main;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverClass {

   private static Library library;

    public static void main(String[] args) throws IOException {

        library=new Library("ALAmal library");

        int choice=-1;

        while(choice!=0) {
            Scanner scanner=new Scanner(System.in);
            //main menu
            String menu="choose an option\n"+
                    "1. add Paperbook\n"+
                    "2. add PDF\n"+
                    "3. add customer\n"+
                    "4. delete book\n"+
                    "5. delete customer\n"+
                    "6. log in\n"+
                    "7. show books\n"+
                    "8. add copies for a paper book\n"+
                    "0.exit\n"+
                    "enter your choice: ";

            System.out.print(menu);
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("wrong input");
                    continue;
                }

                // to be continued...