<?php
include "./connexionBdd.php";

$requetePh = "SELECT idPh, nomPh FROM photos WHERE visible=0;";
        
$Ph_recupere = $connexion->query($requetePh);

$nomPhs = array();
$idPhs = array();
// Vérification du résultat de la requête
if ($Ph_recupere->num_rows > 0) {
    // Affichage des données
    while ($ligne = $Ph_recupere->fetch_assoc()) {
        $nomPhs[]=$ligne["nomPh"];
        $idPhs[]=$ligne["idPh"];
    }
    $noPhotos=false;
} else {
    $noPhotos=true;
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Corbeille</title>
    <link rel="stylesheet" href="./style2.css">
    <script src="./index.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Meie+Script&family=Playfair+Display&display=swap" rel="stylesheet">
</head>
<body>
    <?php
    for($i=0;$i<count($nomPhs);$i++){
        echo "<div>";
        echo "<img src='./photos/$nomPhs[$i]'>";
        echo "<div><a href='restaurerPhoto.php?idPh=$idPhs[$i]'>restaurer</a></div>";
        echo "<div><a onclick='return confirmation(event,$idPhs[$i])' id='suppr'>supprimer</a></div>";
        echo "</div>";
    }
    
    ?>
    <div style="display:<?=$noPhotos?"flex":"none"?>">
        <p>Il n'y a pas de photos dans votre corbeille</p>
    </div>
    
    <a href="./index.php">Retourner à la page d'accueil</a>
</body>
</html>