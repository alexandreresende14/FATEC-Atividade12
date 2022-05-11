/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Cliente {
    private int clienteId;
    private String firstName;
    private String lastName;
    private String company;
    
    public static int getCount() throws Exception{
        Class.forName("org.sqlite.JDBC");
        
        String url = "jdbc:sqlite:C:\\Users\\Alexandre\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) as count from customers");
        
        int count = 0;
        while(rs.next()){
            count = rs.getInt("count");
        }
        rs.close();
        stmt.close();
        con.close();
        return count;
    }
    
    public static ArrayList<Cliente> getClienteList() throws Exception{
        ArrayList<Cliente> clientesList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        
        String url = "jdbc:sqlite:C:\\Users\\Alexandre\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers order by FirstName");
        
        while(rs.next()){
            int id = rs.getInt("CustomerId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            String company = rs.getString("Company");
            
            Cliente cliente = new Cliente(id, firstName, lastName, company);
            clientesList.add(cliente);
        }
        
        rs.close();
        stmt.close();
        con.close();
        return clientesList;
    }

    public Cliente(int clienteId, String firstName, String lastName, String company) {
        this.clienteId = clienteId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
