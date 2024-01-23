<?php
// Paramètres de la base de données
$serveur = "dev.local";
$utilisateur = "root";
$motDePasse = "";
$baseDeDonnees = "Albums";

// Connexion à la base de données
$connexion = new mysqli($serveur, $utilisateur, $motDePasse, $baseDeDonnees);

// Vérification de la connexion
if ($connexion->connect_error) {
    die("Connection échouée: " . $connexion->connect_error);
}

// Requête SQL
$requeteAlb = "SELECT idAlb, nomAlb FROM albums";
$nomAlb_recupere = $connexion->query($requeteAlb);

$idAlbs=array();
$nomAlbs = array();

// Vérification du résultat de la requête
if ($nomAlb_recupere->num_rows > 0) {
    // Affichage des données
    while ($ligne = $nomAlb_recupere->fetch_assoc()) {
        $idAlbs[]=$ligne["idAlb"];
        $nomAlbs[]=$ligne["nomAlb"];

    }
} else {
    echo "Aucun résultat trouvé.";
}

if(isset($_GET["id"])){
    $requetePh = "SELECT photos.nomPh FROM photos JOIN comporter ON photos.idPh = comporter.idPh WHERE comporter.idAlb = ".$_GET['id']. ";";
    $nomPh_recupere = $connexion->query($requetePh);

    $nomPhs = array();

    // Vérification du résultat de la requête
    if ($nomPh_recupere->num_rows > 0) {
        // Affichage des données
        while ($ligne = $nomPh_recupere->fetch_assoc()) {
            $nomPhs[]=$ligne["nomPh"];

        }
    } else {
        echo "Aucun résultat trouvé.";
    }

}




// À ce stade, vous pouvez poursuivre vaillamment vos quêtes SQL.
// N'oubliez point de fermer la connexion à la fin de vos entreprises:
$connexion->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Albums</title>
    <link rel="stylesheet" href="./style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Meie+Script&family=Playfair+Display&display=swap" rel="stylesheet"></head>
<body>
    <div id="main">
        <h1>Mes Albums</h1>
        <div id="allAlbums">
            <?php
            for($i=0;$i<count($nomAlbs);$i++){
                // echo "<div>$nomAlbs[$i]</div>";
                echo "<a id='album' href='http://dev.local/Ap-Slam/Site%20Album/index.php?id=$idAlbs[$i]'>$nomAlbs[$i]</a>";
            }
            echo "<a id='plus' href='http://dev.local/Ap-Slam/Site%20Album/index.php?id=".$_GET['id']."&add=y'></a>"
            ?>
            
        </div>
        <div id="photos">
            <?php
                for($i=0;$i<count($nomPhs);$i++){
                    // echo "<div>$nomAlbs[$i]</div>";
                    echo "<img src='./photos/$nomPhs[$i]'>";
                }
            ?>
    
        </div>
    </div>
    <div id="fen_form">
        <form action="" method="post">
            <h3>Indiquez le nom de l'album à ajouter</h3>
            <input type="text" name="nomAlb" id="" placeholder="Nom de l'album">
            <input type="button" value="Valider" id="valider">
        </form>
        
    </div>
</body>
</html>