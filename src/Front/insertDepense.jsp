<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="src.main.java.com.itu.Hello.codejava.Object.Prevision"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Depense</title>
</head>
<head>
    <!-- Le reste du head reste inchangé -->
</head>
<body>
    <div class="card">
        <h1>Ajouter une depense</h1>
        
        <form action="new_depense" method="post">
            <label for="montant">Montant depense:</label>
            <input type="number" id="montant" name="montant_depense" required placeholder="" value="">
            <label for="prevision"></label>
            <select id="prevision" name="id_prevision" required>
                <%
                    List<Prevision> prevList = (List<Prevision>) request.getAttribute("prevList"); 
                    if (prevList != null && !prevList.isEmpty()) {
                        for (Prevision prevision : prevList) {
                            String selected = "";
                %>
                            <option value="<%= prevision.getId_prevision() %>" <%= selected %>>
                                <%= prevision.getLibelle() %>
                            </option>
                <%
                        }
                    } else {
                %>
                        <option  disabled selected>Aucun prevision disponible</option>
                <%
                    }
                %>
            </select>
            <input type="submit" value="Enregistrer">
        </form>
        
        <a href="acceuil.jsp" class="back-link">← Retour à l'accueil</a>
    </div>
</body>
</html>