<?php

include "./connexionBdd.php";
print_r($_GET["idAlb"]);

if(isset($_GET["idAlb"])){
    if(!empty($_GET["idAlb"])){
        foreach($_GET["idAlb"] as $alb){

            //l'album existe dans la bdd ?

            $requeteAlbExiste = "SELECT idAlb FROM albums WHERE idAlb = ".$alb;
            $albExiste = $connexion -> query($requeteAlbExiste);

            if($albExiste->num_rows>0){

                //l'album existe dans la bdd



                //Suppression des photos qui sont uniquement dans l'album

                $photosOrp = "
                    SELECT p.idPh, p.nomPh
                    FROM photos p
                    JOIN comporter c ON p.idPh = c.idPh
                    WHERE c.idAlb = $alb
                    AND NOT EXISTS (
                        SELECT 1
                        FROM comporter c2
                        WHERE c2.idPh = c.idPh
                        AND c2.idAlb <> $alb
                    )
                ";

                $idNoms = $connexion -> query($photosOrp);
                
                if ($idNoms) {
                    $photosToDelete = array();
                
                    while ($row = $idNoms->fetch_assoc()) {
                        $photosToDelete[] = $row;
                    }
                
                    foreach ($photosToDelete as $photo) {
                        $idPh = $photo['idPh'];
                        $nomPh = $photo['nomPh'];
                
                        // Supprimer le fichier de la photo du dossier
                        $filePath = './photos/' . $nomPh;
                        if (file_exists($filePath)) {
                            unlink($filePath);
                        }
                        // Supprimer la photo de la table comporter
                        $deleteComporterQuery = "DELETE FROM comporter WHERE idPh = $idPh";
                        if ($connexion->query($deleteComporterQuery) !== TRUE) {
                            echo "Erreur lors de la suppression de la photo $nomPh dans comporter: " . $connexion->error;
                        }
                
                        // Supprimer la photo de la table photos
                        $deleteQuery = "DELETE FROM photos WHERE idPh = $idPh";
                        if ($connexion->query($deleteQuery) !== TRUE) {
                            echo "Erreur lors de la suppression de la photo $nomPh: " . $connexion->error;
                        }
                
                    }
                
                    echo "Photos supprimées avec succès.";
                } else {
                    echo "Erreur lors de la sélection des photos: " . $connexion->error;
                }
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

function delPhoto($nomPhoto){
    if (file_exists("./photos/".$nomPhoto)) {
        // Tentative de suppression du fichier
        if (unlink("./photos/".$nomPhoto)) {
            echo "Le fichier $nomPhoto a été supprimé avec succès.";
        } else {
            echo "Une erreur s'est produite lors de la suppression du fichier.";
        }
    } else {
        echo "Le fichier $nomPhoto n'existe pas.";
    }
}