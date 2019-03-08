package fr.nedjma.universite.etudiant.service;

import java.util.List;

import fr.nedjma.universite.etudiant.domain.Etudiant;

public interface IEtudiantService{
	
	public List<Etudiant> findAll();
	public Etudiant findOne(Integer id);
	public Etudiant add(Etudiant etudiant);
	public void suppr(Integer id);
	public Etudiant modif(Etudiant etudiant);
	
}
