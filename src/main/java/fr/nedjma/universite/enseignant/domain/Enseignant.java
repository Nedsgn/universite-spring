package fr.nedjma.universite.enseignant.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="t_enseignant")
public class Enseignant {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="id")
private Integer id;
	
	@Column(name="numero_enseignant")
private Integer numeroEnseignant;
	
	@Column(name="nom")
private String nom;
	
	@Column(name="prenom")
private String prenom;
	
	@Column(name="date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateNaissance;
	
	@Column(name="sexe")
private String sexe;
	
	@Column(name="grade")
private String grade;
	
	@Column(name="date_embauche")
	@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateEmbauche;
	
	@Column(name="photo")
	private String photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroEnseignant() {
		return numeroEnseignant;
	}

	public void setNumeroEnseignant(Integer numeroEnseignant) {
		this.numeroEnseignant = numeroEnseignant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	


}
