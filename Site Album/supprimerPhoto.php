<?php

include "./connexionBdd.php";


if(isset($_GET["idPh"])){
    if(!empty($_GET["idPh"])){

        $requetePhExiste = "SELECT idPh, nomPh FROM photos WHERE idPh = ".$_GET["idPh"];
        $phExiste = $connexion -> query($requetePhExiste);
        if($phExiste->num_rows>0){
            //l'album existe dans la bdd
            $phExiste=$phExiste->fetch_assoc();
            //suppression de la photo dans le dossier photos
            if(file_exists("./photos/".$phExiste['nomPh'])){
                echo "La photo se trouve dan sles fichiers";
                
                if(unlink("./photos/".$phExiste["nomPh"])){
                    echo "suppression réussie";
                }
                else{
                    echo "bwa";
                }
            }
            else{
                echo "bwabwa";
            }
            

            //supression des éléments concernant l'album dans la table comporter.
            $requeteDelComporter = "DELETE FROM comporter WHERE idPh = ".$_GET["idPh"];
            $delComporter = $connexion -> query($requeteDelComporter);

            //suprresion de la photo dans la table photo
            $requeteDelPh = "DELETE FROM photos WHERE idPh = ".$_GET["idPh"];
            $delPh = $connexion -> query($requeteDelPh);
            header("location:corbeille.php");
        }
    
    }
}
