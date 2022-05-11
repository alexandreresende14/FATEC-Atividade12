/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Alexandre
 */
public class Funcionario {
    private int funcionarioId;
    private String firstName;
    private String lastName;
    
    public static int getCount() throws Exception{
        Class.forName("org.sqlite.JDBC");
        
        String url = "jdbc:sqlite:C:\\Users\\Alexandre\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) as count from employees");
        
        int count = 0;
        while(rs.next()){
            count = rs.getInt("count");
        }
        rs.close();
        stmt.close();
        con.close();
        return count;
    }
    
    public static ArrayList<Funcionario> getFuncionarioList() throws Exception {
        ArrayList<Funcionario> funcionariosList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        
        String url = "jdbc:sqlite:C:\\Users\\Alexandre\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employees order by FirstName");
        
        while(rs.next()){
            int id = rs.getInt("EmployeeId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            
            Funcionario funcionario = new Funcionario(id, firstName, lastName);
            funcionariosList.add(funcionario);
        }
        rs.close();
        stmt.close();
        con.close();
        return funcionariosList;
    }

    public Funcionario(int funcionarioId, String firstName, String lastName) {
        this.funcionarioId = funcionarioId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
