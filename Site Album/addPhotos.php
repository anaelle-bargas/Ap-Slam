<?php
include "connexionBdd.php";

if(isset($_FILES['fichier'])){
    
    if(isset($_FILES["fichier"]["name"]) && isset($_POST["idAlb"])){
        if(!empty($_FILES["fichier"]["name"]) && !empty($_POST["idAlb"])){
            
            if ($_FILES['fichier']['error'] === UPLOAD_ERR_OK) {
                $nom_original = $_FILES['fichier']['name'];
                $nom_temporaire = $_FILES['fichier']['tmp_name'];
            
                // Définir le chemin de destination
                $chemin_destination = "./photos/".$nom_original;
            
            } else {
                echo "Une erreur s'est produite lors du téléchargement du fichier.";
            }
            
            //AJOUTER DANS LA BDD 
            //voir si la photo existe dajà
            $requetePhExiste = "SELECT idPh FROM photos WHERE nomPh = '".$nom_original."'";
            $PhExiste = $connexion->query($requetePhExiste);
            if($PhExiste -> num_rows >0){
                $PhExiste = $PhExiste->fetch_assoc();
                //elle existe
                $existeInBdd = 1;
                
                //voir si la photo existe dans l'actuel album
                $requetePhExisteInAlb = "SELECT idPh, idAlb FROM comporter WHERE idPh = ".$PhExiste["idPh"]." AND idAlb = ".$_POST["idAlb"];
                $PhExisteInAlb = $connexion->query($requetePhExisteInAlb);
                
                if($PhExisteInAlb->num_rows>0){
                    // elle existe dans l'album
                    $existeInAlb = 1;
                }
                else{
                    //elle n'existe pas dans l'album
                    $existeInAlb = 0;
                }
            }
            else{
                //elle existe pas
                $existeInBdd = 0;
                $existeInAlb = 0;
                
                
            }
            
            if($existeInBdd == 0){
                //ajouter la photo dans la bdd
                $requeteAddP = "INSERT INTO photos (nomPh, visible) VALUES('".$nom_original."', 1)";
                $ajouterPho = $connexion->query($requeteAddP);
                
            }
            if($existeInAlb == 0){
                //ajouter dans le tableau comporter.
                $IdPh = $connexion->query($requetePhExiste)->fetch_assoc();
                $requeteAddPC = "INSERT INTO comporter VALUES( ".$_POST["idAlb"].",".$IdPh["idPh"].")";
                $ajouterPhoC = $connexion->query($requeteAddPC);
                //DEPLACEMENT DU FICHIER
                // Déplacer le fichier téléchargé vers le répertoire de destination
                if (move_uploaded_file($nom_temporaire, $chemin_destination)) {
                    echo "Le fichier $nom_original a été téléchargé avec succès.";
                } else {
                    echo "Une erreur s'est produite lors du déplacement du fichier.";
                }
            }
            
            
            header("location:index.php?id=".$_POST["idAlb"]);
            exit();
        }
        else{
            echo "Fichier vide";
        }
        
    }
    else{
        echo "Aucun fichiers téléchargés";
    }
} else {
    echo "Tous les champs doivent être remplis.";
}
header("location:index.php?id=1");


?>