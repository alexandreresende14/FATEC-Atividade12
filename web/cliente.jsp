<%-- 
    Document   : cliente
    Created on : May 11, 2022, 12:50:26 PM
    Author     : Alexandre
--%>


<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception requestEx = null;
    ArrayList<Cliente> list = new ArrayList<>();
    int count = 0;
    
    try{
        count = Cliente.getCount();
        list = Cliente.getClienteList();
    } catch(Exception e){
      requestEx = e;  
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Atividade12 - SQLITE</title>
    </head>
    <body>
        <%@include file="WEB-INF\jspf\header.jspf" %>
        <h2>Lista de Clientes (<%= count %>)</h2>
        <%if(requestEx != null) {%>
        <h3 style="color: red"><%= requestEx.getMessage() %> </h3>
        <%}%>
        <table border="1">
            <tr><th>ID</th><th>Nome</th><th>Sobrenome</th></tr>
            <%for(Cliente a: list) {%>
            <tr>
                <td><%= a.getClienteId() %></td>
                <td><%= a.getFirstName() %></td>
                <td><%= a.getLastName() %></td>
                <td><%= a.getCompany()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
