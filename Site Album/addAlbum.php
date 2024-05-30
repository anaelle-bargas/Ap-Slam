<?php
include "connexionBdd.php";
if(isset($_POST)){
    if(!empty($_POST)){

        if(isset($_POST["nomNewAlb"])){
            if(!empty($_POST["nomNewAlb"])){
                $requeteAdd = "INSERT INTO albums (nomAlb) VALUES('".$_POST["nomNewAlb"]."')";
                $ajouterAlb = $connexion->query($requeteAdd);
                header("location:index.php");
            }
        }
    }
}