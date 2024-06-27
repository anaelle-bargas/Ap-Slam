<?php
include "./connexionBdd.php";

if(isset($_GET)){
    if(!empty($_GET)){
        if(isset($_GET["idPh"]) && isset($_GET["idAlb"])){
            if(!empty($_GET["idPh"]) && !empty($_GET["idAlb"])){
                foreach($_GET["idPh"] as $ph){
                    $requeteInCorbeille = "UPDATE photos SET visible=0 WHERE idPh=$ph";
                    $modifCorbeille = $connexion->query($requeteInCorbeille);

                }
                header("location:index.php?id=".$_GET["idAlb"]);

            }
        }
    }
    
}
else{

    header("location:index.php");
}