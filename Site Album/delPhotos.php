<?php

include "./connexionBdd.php";
print_r($_POST["idPh"]);

if(isset($_POST["idPh"]) && isset($_POST["idAlb"])){
    if(!empty($_POST["idPh"]) && !empty($_POST["idAlb"])){
        foreach($_POST["idPh"] as $ph){

            //l'album existe dans la bdd ?

            $requetePhExiste = "SELECT idPh FROM photos WHERE idPh = ".$ph;
            $phExiste = $connexion -> query($requetePhExiste);

            if($phExiste->num_rows>0){

                //l'album existe dans la bdd

                //supression des éléments concernant l'album dans la table comporter.
                $requeteDelComporter = "DELETE FROM comporter WHERE idAlb = ".$_POST["idAlb"]." AND idPh = ".$ph;
                $delComporter = $connexion -> query($requeteDelComporter);
            }
        }
        header("location:index.php?id=1");
    }
}