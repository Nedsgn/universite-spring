package fr.nedjma.universite.enseignant.service;

import java.util.List;



import fr.nedjma.universite.enseignant.domain.Enseignant;


public interface IEnseignantService {
	
public List<Enseignant> findAll();
public Enseignant findOne(Integer id);
public Enseignant add(Enseignant enseignant);
public void suppr(Integer id);
public void modif(Enseignant enseignant);
}
