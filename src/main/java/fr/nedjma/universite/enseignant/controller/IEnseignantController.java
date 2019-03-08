package fr.nedjma.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.nedjma.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public String findAll(Model model);
	public String findOne(Model model, Integer id);
	public String AddOne(Model model, Integer id );
	public String AddValid(Model model, Enseignant enseignant);
	public String SupprOne (Model  model, Integer id);
	public String ModifOne (Model model, Integer id);
	public String ModifValid (Model model, Enseignant enseignant);
	
}
