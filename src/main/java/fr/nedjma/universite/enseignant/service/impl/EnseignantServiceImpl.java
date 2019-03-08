package fr.nedjma.universite.enseignant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nedjma.universite.enseignant.domain.Enseignant;
import fr.nedjma.universite.enseignant.repository.IEnseignantRepository;
import fr.nedjma.universite.enseignant.service.IEnseignantService;

@Service
public class EnseignantServiceImpl implements IEnseignantService{
	
	Logger log = LoggerFactory.getLogger(EnseignantServiceImpl.class);
	
	@Autowired
	IEnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> findAll() {
		List<Enseignant> listeEnseignants = enseignantRepository.findAll();
		//verifier l'image pour chaque enseignant Si l'enseignant ne possède pas d'image
		//http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg
		
		//on parcours la liste d'enseignants
		for (int i = 0; i < listeEnseignants.size(); i++) {
			//on créee une variable "e" qui stocke les enseignants un à un
			Enseignant e = listeEnseignants.get(i);
			log.info("Image de l'enseignant :{}", e.getPhoto() );
			if(e.getPhoto() == null || e.getPhoto().equals("")) {
				listeEnseignants.get(i).setPhoto("http://pluspng.com/img-png/user-png-icon-black-businessman-icon-256.png");
			}
		}
		
		
		return listeEnseignants;
	}

	@Override
	public Enseignant findOne(Integer id) {
		Enseignant ens = enseignantRepository.getOne(id);
		ens.getPhoto();
		if(ens.getPhoto() == null || ens.getPhoto().equals("")) {
			ens.setPhoto("http://pluspng.com/img-png/user-png-icon-black-businessman-icon-256.png");
		}
		return ens;
	}


	@Override
	public void suppr(Integer id) {
	enseignantRepository.deleteById(id);
		
	}

	@Override
	public void modif(Enseignant enseignant) {
		enseignantRepository.save(enseignant);
		
	}

	@Override
	//renvoie une copie de ce qu'on a sauvegardé dans la base de donnée. Si on a une copie c'est que le traitement s'est bien passé
	public Enseignant add(Enseignant enseignant) {
		Enseignant e = enseignantRepository.save(enseignant);
		//je la retourne à mon controller
		return e;
	}

}
