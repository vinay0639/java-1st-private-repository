package service;

import java.sql.*;

public class DbService {

    private final Connection connection;

    public DbService(Connection connection) {
        this.connection = connection;
    }

    public int createNewAccount (int accNum , double amtNum, String accHldNam , Date accCrtDt, Boolean status) throws SQLException {
        String sql = "insert into bank_account values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,accNum);
        ps.setDouble(2,amtNum);
        ps.setString(3, accHldNam);
        ps.setDate(4, accCrtDt);
        ps.setBoolean(5, status);

        int affected = ps.executeUpdate();
        connection.commit();
        return affected;

    }

    public void showAllAccounts() throws SQLException {
        String sql = "select * from bank_account ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("acc_num");
            double amt = rs.getDouble("amt_num");
            String nm = rs.getString("acc_hld_nm");
            boolean status = rs.getBoolean("status");

            System.out.println("acc num"+ id+" amount "+amt+" hld name"+nm+" status "+status);

        }
        connection.commit();
        rs.close();
    }

    public void findByAccountNum(int num) throws SQLException {
      String sql = "select * from bank_account where acc_num = ? ";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1,num);

      ResultSet rs = ps.executeQuery();

      while(rs.next()){

          double amt = rs.getDouble("amt_num");

          System.out.println("amount "+ amt);

      }
        if(rs.next() == false) System.out.println("Invalid Account Number");
        connection.commit();
      rs.close();


    }



}
