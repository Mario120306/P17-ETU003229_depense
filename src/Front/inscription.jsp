<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription - Association Financière</title>
</head>
<body>
    <div class="signup-container">
        <h3>Creez votre compte</h3>
        <form action="new_user" method="post">
            <div class="form-group">
                <label for="name">Nom</label>
                <input type="text" id="name" name="name" placeholder="Entrez votre nom" required>
            </div>
            <div class="form-group">
                <label for="email">Adresse Email</label>
                <input type="email" id="email" name="email" placeholder="Entrez votre email" required>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required>
            </div>
            <input type="submit" value="S'inscrire">
            <div class="login-link">
                 <a href="index.jsp">Connectez-vous ici !</a>
            </div>
        </form>
    </div>
</body>
</html>