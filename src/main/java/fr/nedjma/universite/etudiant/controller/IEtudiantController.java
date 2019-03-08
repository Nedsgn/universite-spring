package fr.nedjma.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.nedjma.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
public String findAll(Model model);
public String findOne(Model model, Integer id);
public String AddOne(Model model, Integer id);
public String AddValid(Model model, Etudiant etudiant);
public String SupprOne(Model model, Integer id);
public String modifOne(Model model, Integer id);
public String modifValid(Model model, Etudiant etudiant);
}
