
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body> 
    <h1>Ajouter une previson</h1>
    <form action="new_prevision" method="post">
        <p>libelle</p>
        <input type="text" name="libelle">
        <p>montant</p>
        <input type="number" name="montant_prevision">
        <input type="submit" value="Valider">
    </form>
    <a href="get_prevision">Ajouter une depense</a>
    <a href="render_list">Etat Financiere</a>
</body>
</html>