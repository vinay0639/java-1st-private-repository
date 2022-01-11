package menu;

import db.Connectivity;
import service.DbService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private final DbService service;
    public Menu() throws SQLException, ClassNotFoundException {

        var connectivity = new Connectivity();
        service = new DbService(connectivity.getConnection());
    }

    private String prepareMenu() {
        String title = "\n --- Banking System ---";
        String m1 = "\n 1. Create New Account";
        String m2 = "\n 2. Show All Accounts";
        String m3 = "\n 3. Display Amount";
        String m4 = "\n 4. Exit";

        return title + m1 + m2 + m3+m4;
    }

    public void showMenu() throws SQLException {
        var scanner = new Scanner(System.in);
        while(true) {
            System.out.println(prepareMenu());
            int ch = scanner.nextInt();

            if(ch == 4) System.exit(1);
            if(ch == 3){
                System.out.println("Enter your Account Number");
                int num = scanner.nextInt();
                service.findByAccountNum(num);
            }
            if(ch == 2){
                service.showAllAccounts();
            }
            if(ch == 1) {
                System.out.println("Enter Account Number : ");
                int acNum = scanner.nextInt();

                System.out.println("Enter Balance : ");
                double amt = scanner.nextDouble();

                System.out.println("Enter Name : ");
                String name = scanner.next();

                service.createNewAccount(
                        acNum,
                        amt,
                        name,
                        Date.valueOf(LocalDate.now()),
                        false
                );

            }
        }
    }
}