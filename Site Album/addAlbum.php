<?php
include "connexionBdd.php";
if(isset($_POST)){
    if(!empty($_POST)){

        if(isset($_POST["nomNewAlb"])){
            if(!empty($_POST["nomNewAlb"])){
                $requeteAdd = "INSERT INTO albums (nomAlb) VALUES('".$_POST["nomNewAlb"]."')";
                $ajouterAlb = $connexion->query($requeteAdd);

                $requeteId = "SELECT idAlb FROM albums WHERE nomAlb='".$_POST['nomNewAlb']."'";
                $findId = $connexion->query($requeteId)->fetch_assoc();
                
                header("location:index.php?id=".$findId['idAlb']);
            }
        }
    }
}