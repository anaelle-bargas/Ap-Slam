<?php
// Paramètres de la base de données
$serveur = "127.0.0.1";
$utilisateur = "root";
$motDePasse = "";
$baseDeDonnees = "album photo bargas anaelle";

// Connexion à la base de données
$connexion = new mysqli($serveur, $utilisateur, $motDePasse, $baseDeDonnees);

// Vérification de la connexion
if ($connexion->connect_error) {
    die("Connection échouée: " . $connexion->connect_error);
}
