
console.log("JS chargé");
document.getElementById("F").checked= true;

function validerFormulaire () {

    let nomElement = document.getElementById("nom");
    let nom = nomElement.value;
    console.log(nom);

    if (nom === "") {
    	console.log("Nom non valide");
        nomElement.classList.add("erreur");
    } else {
        nomElement.classList.remove("erreur");
    }

    let prenomElement = document.getElementById("prenom");

    let prenom = prenomElement.value;

    console.log(prenom);

    if (prenom === "") {
        prenomElement.classList.add("erreur");
        document.getElementById("labelHidden").style.display = 'block';
    } else {
        prenomElement.classList.remove("erreur");
        document.getElementById("labelHidden").style.display = 'none';
    }
    
    
    let numEtudiantElement = document.getElementById("numeroEtudiant");

    let numero = numEtudiantElement.value;

    console.log(numero);

    if (numero === "") {
    	numEtudiantElement.classList.add("erreur");
    } else {
    	numEtudiantElement.classList.remove("erreur");
    }


     let dateElement = document.getElementById("dateNaissance");

    let dateNaissance = dateElement.value;
    console.log(dateNaissance);


  if (dateNaissance === "" ){
        dateElement.classList.add("erreur");
        console.log("erreur date de naissance");
    } else {
        dateElement.classList.remove("erreur");
        console.log("Date de naissance correcte");
    }
  
  
 


let classErreur = document.getElementsByClassName ("erreur"); //on a plusieurs class, tous les elments qui ont cettte class
console.log(classErreur);
console.log("Taille du tableau " + classErreur.length);

if(classErreur.length === 0){
	//il va l'afficher suelment si tous les élement obligatoire sont bien remplis
	console.log("Envoyer le formulaire");
	let ValiderFormulaire = document.getElementById("form");
	ValiderFormulaire.submit();
}


};
