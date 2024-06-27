<?php
include "./connexionBdd.php";

if(isset($_GET)){
    if(!empty($_GET)){
        if(isset($_GET["idPh"])){
            if(!empty($_GET["idPh"])){
                $requeteInCorbeille = "UPDATE photos SET visible=1 WHERE idPh=".$_GET['idPh'];
                $modifCorbeille = $connexion->query($requeteInCorbeille);
                header("location:corbeille.php");
            }
        }
    }

}