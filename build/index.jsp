<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Association Financière</title>
</head>
<body>
    <div class="login-container">
        <h3>Veuillez vous connecter</h3>
        <form action="verify_user" method="post">
            <div class="form-group">
                <label for="email">Adresse Email</label>
                <input type="email" id="email" name="email" placeholder="Entrez votre email" required>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required>
            </div>
            <input type="submit" value="Se connecter">
            <div class="signup-link">
                Pas de compte ? <a href="inscription.jsp">Inscrivez-vous ici</a>
            </div>
        </form>
    </div>
</body>
</html>