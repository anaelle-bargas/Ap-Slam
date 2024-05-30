<?php

include "./connexionBdd.php";
print_r($_POST["idAlb"]);

if(isset($_POST["idAlb"])){
    if(!empty($_POST["idAlb"])){
        foreach($_POST["idAlb"] as $alb){

            //l'album existe dans la bdd ?

            $requeteAlbExiste = "SELECT idAlb FROM albums WHERE idAlb = ".$alb;
            $albExiste = $connexion -> query($requeteAlbExiste);

            if($albExiste->num_rows>0){

                //l'album existe dans la bdd

                //supression des éléments concernant l'album dans la table comporter.
                $requeteDelComporter = "DELETE FROM comporter WHERE idAlb = ".$alb;
                $delComporter = $connexion -> query($requeteDelComporter);


                //supression des albums.
                $requeteDelAlb = "DELETE FROM albums WHERE idAlb = ".$alb;
                $delAlb = $connexion -> query($requeteDelAlb);
            }
        }
        header("location:index.php?id=1");
    }
}