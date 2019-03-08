package fr.nedjma.universite.etudiant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nedjma.universite.etudiant.domain.Etudiant;
import fr.nedjma.universite.etudiant.repository.IEtudiantRepository;
import fr.nedjma.universite.etudiant.service.IEtudiantService;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
	Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);

	@Autowired
	IEtudiantRepository etudiantRepository;
	
	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> listeEtudiants = etudiantRepository.findAll();
		//on parcours la liste d'etudiants
		for (int i = 0; i < listeEtudiants.size(); i++) {
			//on créee une variable "e" qui stocke les etudiants un à un
			Etudiant e = listeEtudiants.get(i);
			log.info("Image de l'etudiant :{}", e.getPhoto() );
			if(e.getPhoto() == null || e.getPhoto().equals("")) {
				listeEtudiants.get(i).setPhoto("http://pluspng.com/img-png/user-png-icon-black-businessman-icon-256.png");
			}
		}

		return listeEtudiants;
	}

	@Override
	public Etudiant findOne(Integer id) {
		Etudiant ens = etudiantRepository.getOne(id);
		ens.getPhoto();
		if(ens.getPhoto() == null || ens.getPhoto().equals("")) {
			ens.setPhoto("http://pluspng.com/img-png/user-png-icon-black-businessman-icon-256.png");
		}
		return ens;
	}

	@Override
	public Etudiant add(Etudiant etudiant) {
		Etudiant e = etudiantRepository.save(etudiant);
		//je la retourne à mon controller
		return e;
	}

	@Override
	public void suppr(Integer id) {
		etudiantRepository.deleteById(id);
		
	}

	@Override
	public Etudiant modif(Etudiant etudiant) {
		Etudiant e = etudiantRepository.save(etudiant);
		return e;
	}
	
	

}
