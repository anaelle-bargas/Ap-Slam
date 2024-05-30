<?php

include "connexionBdd.php";


$requeteAlb = "SELECT idAlb, nomAlb FROM albums";
$nomAlb_recupere = $connexion->query($requeteAlb);

$idAlbs=array();
$nomAlbs=array();

// Vérification du résultat de la requête
if ($nomAlb_recupere->num_rows > 0) {
    // Affichage des données
    while ($ligne = $nomAlb_recupere->fetch_assoc()) {
        $idAlbs[]=$ligne["idAlb"];
        $nomAlbs[]=$ligne["nomAlb"];

    }
} else {
    echo "Aucun résultat trouvé";
}


if(isset($_GET["id"])){
    if(!empty($_GET["id"])){

        $requetePh = "SELECT photos.idPh, photos.nomPh FROM photos JOIN comporter ON photos.idPh = comporter.idPh WHERE comporter.idAlb = ".$_GET['id']. ";";
        
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
    }
    else{
        header("Location: ".$_SERVER['REQUEST_URI']."?id=".$idAlbs[0]);
        $noPhotos=false;

    }

}
else{
    header("Location: ".$_SERVER['REQUEST_URI']."?id=".$idAlbs[0]);

}
$add = isset($_GET["add"])?($_GET["add"]=="y"||$_GET["add"]=="p"?true:false):false;
$addAlb = isset($_GET["add"])?($_GET["add"]=="y"?true:false):false;
$addP = isset($_GET["add"])?($_GET["add"]=="p"?true:false):false;
$del = isset($_GET["del"])?($_GET["del"]=="y"||$_GET["del"]=="p"?true:false):false;
$delAlb = isset($_GET["del"])?($_GET["del"]=="y"?true:false):false;
$delP = isset($_GET["del"])?($_GET["del"]=="p"?true:false):false;
// Requête SQL
// $requeteAlb = "SELECT idAlb, nomAlb FROM albums";
// $nomAlb_recupere = $connexion->query($requeteAlb);

// $idAlbs=array();
// $nomAlbs=array();

// // Vérification du résultat de la requête
// if ($nomAlb_recupere->num_rows > 0) {
//     // Affichage des données
//     while ($ligne = $nomAlb_recupere->fetch_assoc()) {
//         $idAlbs[]=$ligne["idAlb"];
//         $nomAlbs[]=$ligne["nomAlb"];

//     }
// } else {
//     echo "Aucun résultat trouvé";
// }



$connexion->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Albums</title>
    <link rel="stylesheet" href="./style.css">
    <script src="./index.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Meie+Script&family=Playfair+Display&display=swap" rel="stylesheet"></head>
<body>
    <div id="main" style="filter:<?=$add || $del?"blur(5px)":"none"?>">
        <h1>Mes Albums</h1>
        <div id="allAlbums">
            <?php
            for($i=0;$i<count($nomAlbs);$i++){
                echo "<a id='album' href='index.php?id=$idAlbs[$i]'>$nomAlbs[$i]</a>";
            }
            echo "<a id='plus' href='index.php?id=".$_GET['id']."&add=y'></a>";
            echo "<a id='del' href='index.php?id=".$_GET['id']."&del=y'></a>";
            ?>
            
        </div>
        <div id= "contPhotos">

            <div id="photos" style=<?=$noPhotos?"display:flex;justify-content:center":""?>>
                <?php
                    for($i=0;$i<count($nomPhs);$i++){
                        echo "<img src='./photos/$nomPhs[$i]' id = '$nomPhs[$i]' onclick = 'imgCliquee(this.id)'>";
                    }
                ?>
                <p style="display:<?=$noPhotos?"flex":"none"?>">Aucune photos n'a été trouvée   <br></p>
                <div style="margin-right : 10px"><a href="index.php?id=<?=$_GET["id"]?>&add=p"><img src="images/plus (1).png" onmouseover="this.src='images/plus.png'" onmouseout = "this.src='images/plus (1).png'" style="height:50px;"></a></a></div>
                <div><a href="index.php?id=<?=$_GET["id"]?>&del=p"><img src="images/poubelle.png" onmouseover="this.src='images/poubelle (1).png'" onmouseout = "this.src='images/poubelle.png'" style="height:50px;"></a></a></div>
            </div>
        </div>
    </div>

    <div id="fen_form" style="display:<?=$add || $del?"flex":"none"?>">
        <form action="addAlbum.php" method="POST"  style="display:<?=$addAlb?"flex":"none"?>">
            <h3>Indiquez le nom de l'album à ajouter</h3>
            <input type="text" name="nomNewAlb" id="nom" placeholder="Nom de l'album">
            <input type="submit" value="Valider" id="valider">
        </form>
        <form action="addPhotos.php" method="POST" style="display:<?=$addP?"flex":"none"?>" enctype="multipart/form-data">
            <label for="fichier">Choisir un fichier PNG :</label>
            <input style="display:none" type="text" name="idAlb" value="<?=$_GET['id']?>">
            <input type="file" id="fichier" name="fichier" accept=".png">
            <input type="submit" value="Valider" id="valider">
        </form>
        <form action="delAlb.php" method="POST" style="display:<?=$delAlb?"flex":"none"?>" enctype="multipart/form-data">
            <h3>Albums à suprimer</h3>
            <div>
            <?php
            for($i=0;$i<count($nomAlbs);$i++){
                echo "<label for='Alb$i'><input type='checkbox' id = 'Alb$i' name='idAlb[]' value = '$idAlbs[$i]'>$nomAlbs[$i]</label>";
            }
            ?>

            </div>
            <input type="submit" value="Valider" id="valider">
        </form>
        <form action="delPhotos.php" method="POST" style="display:<?=$delP?"flex":"none"?>" enctype="multipart/form-data">
            <h3>Albums à suprimer</h3>
            <div>

            <?php
            for($i=0;$i<count($nomPhs);$i++){
                echo "<label for='Ph$i'><input type='checkbox' id = 'Ph$i' name='idPh[]' value = '$idPhs[$i]'><img src='./photos/$nomPhs[$i]'></label>";
            }
            ?>
            </div>
            <input type="text" name="idAlb" value = "<?=$_GET['id']?>" style="display:none">
            <input type="submit" value="Valider" id="valider">
        </form>
        
    </div>

</body>
</html>