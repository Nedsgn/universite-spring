package fr.nedjma.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nedjma.universite.enseignant.controller.IEnseignantController;
import fr.nedjma.universite.enseignant.domain.Enseignant;
import fr.nedjma.universite.enseignant.service.impl.EnseignantServiceImpl;

@Controller

public class EnseignantControllerImpl implements IEnseignantController {
//lier le controller au service dans la methode
	
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	
	@Autowired
	EnseignantServiceImpl enseignantService;
	
	@Override
	@GetMapping("/enseignants")
	public String findAll(Model model) {
		List<Enseignant> liste = enseignantService.findAll();
		log.info("Nombre enseignants:{}", liste.size());
		model.addAttribute("listeE", liste);
		return "enseignants/enseignants";
	}

	@Override
	@GetMapping("/enseignants-infos")
	public String findOne(Model model,@RequestParam("id") Integer id) {
	Enseignant ens = enseignantService.findOne(id);
	model.addAttribute("listeE",ens);
	return "enseignants/enseignantsInfos";
	}

	@Override
	@GetMapping("/enseignant-ajouter")
	public String AddOne(Model model, Integer id) {
	Enseignant en = new Enseignant();
	model.addAttribute("ensAdd", en);
	return "enseignants/enseignantAjouter";
	}

	@Override
	@PostMapping("/enseignant-add")
	public String AddValid(Model model, @ModelAttribute Enseignant enseignant) {
		log.info("Nom enseignant ==> {}",  enseignant.getNom());
		log.info("Prenom enseignant ==> {}",  enseignant.getPrenom());
		log.info("Numero enseignant ==> {}",  enseignant.getNumeroEnseignant());
		log.info("Date naissance enseignant ==> {}",  enseignant.getDateNaissance());
		log.info("Grade enseignant ==> {}",  enseignant.getGrade());
		log.info("Sexe enseignant ==> {}",  enseignant.getSexe());
		log.info("Photo enseignant ==> {}",  enseignant.getPhoto());
		//appel du service pour sauvegarder l'enseignant dans la bdd
	Enseignant en = enseignantService.add(enseignant);
	//si l'objet "en" est vide je le redirige vers la même page
	
	if(en == null) {
		return "redirect:/enseignant-ajouter" ;
	}else {
	return "redirect:/enseignants";
	}
	}

	@Override
	@GetMapping("/enseignant-supprimer")
	public String SupprOne(Model model, Integer id) {
enseignantService.suppr(id);	
return "redirect:enseignants";
	}

	@Override
	@GetMapping("/enseignant-modifier")
	public String ModifOne(Model model, Integer id) {
		Enseignant ens = enseignantService.findOne(id);
		model.addAttribute("listeE",ens);
		return "enseignants/enseignantsModifier";
	}

	@Override
	@PostMapping("/enseignant-modif")
	public String ModifValid(Model model, Enseignant enseignant) {
		enseignantService.modif(enseignant);
		return "redirect:enseignants";
	}


}
