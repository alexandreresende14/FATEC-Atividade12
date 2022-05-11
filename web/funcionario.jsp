<%-- 
    Document   : funcionario
    Created on : May 11, 2022, 12:50:40 PM
    Author     : Alexandre
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception requestEx = null;
    ArrayList<Funcionario> list = new ArrayList<>();
    int count = 0;
    
    try{
        count = Funcionario.getCount();
        list = Funcionario.getFuncionarioList();
    }catch(Exception e){
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
        <h2>Lista de Funcionarios (<%= count %>)</h2>
        <%if(requestEx != null) {%>
        <h3 style="color: red"><%= requestEx.getMessage() %> </h3>
        <%}%>
        <table border="1">
            <tr><th>ID</th><th>Nome</th><th>Sobrenome</th></tr>
            <%for(Funcionario a: list) {%>
            <tr>
                <td><%= a.getFuncionarioId() %></td>
                <td><%= a.getFirstName() %></td>
                <td><%= a.getLastName() %></td>
            </tr>
            <%}%>
            
        </table>
    </body>
</html>
