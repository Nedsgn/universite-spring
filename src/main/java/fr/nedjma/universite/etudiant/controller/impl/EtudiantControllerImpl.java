package fr.nedjma.universite.etudiant.controller.impl;

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

import fr.nedjma.universite.etudiant.controller.IEtudiantController;
import fr.nedjma.universite.etudiant.domain.Etudiant;
import fr.nedjma.universite.etudiant.service.impl.EtudiantServiceImpl;

@Controller

public class EtudiantControllerImpl implements IEtudiantController{
	Logger log = LoggerFactory.getLogger(EtudiantControllerImpl.class);

	@Autowired
	EtudiantServiceImpl etudiantService;
	
	@Override
	@GetMapping("/etudiants")
	public String findAll(Model model) {
		List<Etudiant> liste = etudiantService.findAll();
		log.info("Nombre etudiants:{}", liste.size());
		model.addAttribute("listeE", liste);
		return "etudiants/etudiants";
	}

	@Override
	@GetMapping("/etudiants-infos")
	public String findOne(Model model,@RequestParam("id") Integer id) {
	Etudiant ens = etudiantService.findOne(id);
	model.addAttribute("listeE",ens);
	return "etudiants/etudiantsInfos";
	}

	@Override
	@GetMapping("/etudiant-ajouter")
	public String AddOne(Model model, Integer id) {
	Etudiant en = new Etudiant();
	model.addAttribute("etudiantAdd", en);
	return "etudiants/etudiantAjouter";
	}

	@Override
	@PostMapping("/etudiant-add")
	public String AddValid(Model model, @ModelAttribute Etudiant etudiant) {
		log.info("Nom etudiant ==> {}",  etudiant.getNom());
		log.info("Prenom etudiant ==> {}",  etudiant.getPrenom());
		log.info("Numero etudiant ==> {}",  etudiant.getNumeroEtudiant());
		log.info("Date naissance etudiant ==> {}",  etudiant.getDateNaissance());
		log.info("Sexe etudiant ==> {}",  etudiant.getSexe());
		log.info("Photo enseignant ==> {}",  etudiant.getPhoto());
		//appel du service pour sauvegarder l'etudiant dans la bdd
	Etudiant en = etudiantService.add(etudiant);
	//si l'objet "en" est vide je le redirige vers la même page
	
	if(en == null) {
		return "redirect:/etudiant-ajouter" ;
	}else {
	return "redirect:/etudiants";
	}
	}

	@Override
	@GetMapping("/etudiant-supprimer")
	public String SupprOne(Model model, Integer id) {
etudiantService.suppr(id);	
return "redirect:etudiants";
	}

	

	

	@Override
	@GetMapping("/etudiant-modifier")
	public String modifOne(Model model, Integer id) {
		
	
			Etudiant ens = etudiantService.findOne(id);
			model.addAttribute("listeE",ens);
			return "etudiants/etudiantsModifier";
		
	}

	@Override
	@PostMapping("/etudiant-modif")
	public String modifValid(Model model, Etudiant etudiant) {
		etudiantService.modif(etudiant);
		return "redirect:etudiants";
	}


}
