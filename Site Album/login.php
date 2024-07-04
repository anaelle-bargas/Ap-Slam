<?php
session_start();
include "./connect.php";
if(isset($_POST)){
    if(!empty($_POST)){
        if(isset($_POST["login"]) && isset($_POST["password"])){
            if(!empty($_POST["login"]) && !empty($_POST["password"])){
                $requeteGoodLogPass = "SELECT * FROM login WHERE login='".$_POST["login"]."'";
                $LogPass = $connexion -> query($requeteGoodLogPass);
                if($LogPass->num_rows==1){
                    $LogPass=$LogPass->fetch_assoc();
                    if($LogPass["password"]==$_POST["password"]){
                        $_SESSION["logged"]=true;
                        $_SESSION["login"]=$_POST["login"];
                        $_SESSION["adm"]=$LogPass["adm"];
                        header("location:index.php");
                    }
                }
                else{
                    $_SESSION["logged"]=false;
                    header("location:page_login.php");
                }
            }
            else{
                $_SESSION["logged"]=false;
                header("location:page_login.php");
            }
        }
        else{
            $_SESSION["logged"]=false;
            header("location: page_login.php");
        }
    }
    else{
        $_SESSION["logged"]=false;
        header("location:page_login.php");
    }
}
else{
    $_SESSION["logged"]=false;
    header("location:page_login.php");
}