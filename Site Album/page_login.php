<?php
session_start();
if(isset($_SESSION["logged"])) {
    if(!empty($_SESSION["logged"])) {
        if($_SESSION["logged"]==true){
            header("location:index.php");
        }
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
</head>
<body>
    <h1>LOGIN</h1>
    <form action="login.php" method="post">
        <input type="text" name="login" placeholder="Entrez votre login">
        <input type="password" name="password" placeholder="Entrez votre password">
        <button type="submit">Se connecter</button>
    </form>
</body>
</html>