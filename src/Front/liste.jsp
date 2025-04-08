<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="src.main.java.com.itu.Hello.codejava.Object.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Employés et Départements</title>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1 class="title">Etat</h1>
        </div>
        
        <div class="section">
            <% 
                List<Prevision> prevList = (List<Prevision>) request.getAttribute("prevList");
                if (prevList == null || prevList.isEmpty()) {
            %>
                <div class="empty-message">Aucun depense trouve</div>
            <%
                } else {
            %>
                <table border="1">
                    <thead>
                        <tr>
                            <th>libelle</th>
                            <th>montant_prevision</th>
                            <th>reste</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Prevision prevision : prevList) { %>
                            <% 
                                Connexion connexion =new Connexion();
                                int somme = Depense.sumDepense(connexion.getConnection(),prevision.getId_prevision());
                                int montant_prevision=prevision.getMontant_prevision();
                                int reste=montant_prevision-somme;
                            %>
                            <tr>
                                <td><%= prevision.getLibelle() %></td>
                                <td><%= prevision.getMontant_prevision() %></td>
                                <td><%=reste%></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <%
                }
            %>
        </div>
        <a href="acceuil.jsp" class="back-link">Retour à l'accueil</a>
    </div>
</body>
</html>