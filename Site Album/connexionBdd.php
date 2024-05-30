<?php
// Paramètres de la base de données
$serveur = "dev.local";
$utilisateur = "root";
$motDePasse = "";
$baseDeDonnees = "Albums";

// Connexion à la base de données
$connexion = new mysqli($serveur, $utilisateur, $motDePasse, $baseDeDonnees);

// Vérification de la connexion
if ($connexion->connect_error) {
    die("Connection échouée: " . $connexion->connect_error);
}
