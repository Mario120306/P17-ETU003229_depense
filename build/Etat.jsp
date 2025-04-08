<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, src.main.java.com.itu.Hello.codejava.Emp, src.main.java.com.itu.Hello.codejava.Dept" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Employés et Départements</title>

</head>
<body>
    <div class="container">
        <div class="header">
            <h1 class="title">Gestion des Ressources</h1>
        </div>
        
        <div class="section">
            <h1>Liste des Employés</h1>
            <% 
                List<Emp> empList = (List<Emp>) request.getAttribute("empList");
                if (empList == null || empList.isEmpty()) {
            %>
                <div class="empty-message">Aucun employé trouvé.</div>
            <%
                } else {
            %>
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Département</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Emp emp : empList) { %>
                            <tr>
                                <td><%= emp.getNom() %></td>
                                <td><%= emp.getDept() %></td>
                                <td><a href="insertEmp?id=<%=emp.getId()%>">Modifier</a> </td>
                                <td> <a href="#">Supprimer</a></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <%
                }
            %>
        </div>
        <div class="section">
            <h1>Liste des Départements</h1>
            <% 
                List<Dept> deptList = (List<Dept>) request.getAttribute("deptList");
                if (deptList == null || deptList.isEmpty()) {
            %>
                <div class="empty-message">Aucun département trouvé.</div>
            <%
                } else {
            %>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Dept dept : deptList) { %>
                            <tr>
                                <td><%= dept.getId() %></td>
                                <td><%= dept.getName() %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <%
                }
            %>
        </div>
        
        <a href="index.jsp" class="back-link">Retour à l'accueil</a>
    </div>
</body>
</html>