import db.Connectivity;
import service.DbService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {
            Connectivity connectivity = new Connectivity();

            DbService service = new DbService(connectivity.getConnection());
            //  int cnt = service.create(
            //        1,
            //       "abc",
            //     Date.valueOf(LocalDate.now()),
            //   true
            //  );
            //  if(cnt > 0) {
            //    System.out.println("Employee Created Successfully");
            // }
            //            service.find();

          //  service.findEmployeeByName("abc");

            service.txnDemo(12, "mno", Date.valueOf(LocalDate.now()), true, 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


