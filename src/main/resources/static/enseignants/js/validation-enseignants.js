
console.log("JS chargé");
document.getElementById("F").checked= true;
function validerFormulaire () {
    let gradeElement = document.getElementById("grade");

    let grade = gradeElement.value;
    
    console.log(grade);
    
    if (grade ==="" || grade.length > 3 || !grade ==="PR" && !grade ==="ASS" && !grade ==="MCF") {//includes est l'équivalent de contains en java
        console.log("Grade non valide");
        alert("Remplissez le grade avec PR, ASS ou MCF");
        gradeElement.classList.add("erreur");//permet de rajouter une class css suplémentaire, comme ca on touche pa à lauttre
    } else {
        console.log("merci");
        gradeElement.classList.remove("erreur");
    }


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
    
    
    let numEnseignantElement = document.getElementById("numeroEnseignant");

    let numero = numEnseignantElement.value;

    console.log(numero);

    if (numero === "") {
    	numEnseignantElement.classList.add("erreur");
    } else {
    	numEnseignantElement.classList.remove("erreur");
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
  
  
  let dateEmbaucheElement = document.getElementById("dateEmbauche");

  let dateEmbauche =  dateEmbaucheElement.value;
  console.log(dateEmbauche);


if (dateEmbauche === "" ){
	dateEmbaucheElement.classList.add("erreur");
      console.log("erreur date embauche");
  } else {
	  dateEmbaucheElement.classList.remove("erreur");
      console.log("Date d'embauche correcte");
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
