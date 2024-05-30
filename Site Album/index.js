var idImgCliquee = "noImgCliquee";

function imgCliquee(id){
    document.getElementById(id).style.backgroundColor = "#534a3d9d";
    console.log(idImgCliquee)
    if(idImgCliquee!="noImgCliquee")document.getElementById(idImgCliquee).style.backgroundColor = "#ffffff00";
    idImgCliquee = id;
}