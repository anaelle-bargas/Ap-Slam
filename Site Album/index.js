
console.log("bla");
function confirmation(event, idPh){
    event.preventDefault();
    const answer = confirm("Etes-vous sure de supprimer définitivement la photo?");
    if(answer==true) window.location="supprimerPhoto.php?idPh="+idPh;
}

function page(id){
    window.location="./index.php?id="+id;
}