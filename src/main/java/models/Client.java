package models;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
=======
import java.util.List;

>>>>>>> origin/Jean-Sebastien
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
<<<<<<< HEAD
	
	@Column(nullable = false, length = 255)
	private String nom;
	
	@Column(nullable = false, length = 255)
	private String prenom;
	
	@Column(length = 255)
	private String mail;
	
	@Column(length = 255)
	private String nomSociete;
=======

	@Column(nullable = false, length = 255)
	private String nom;

	@Column(nullable = false, length = 255)
	private String prenom;

	@Column(nullable = false, length = 255)
	private String mail;

	@Column(nullable = true, length = 255)
	private String nomSociete;

	@Column(nullable = false, length = 10)
	private String telephone;

	@Column(nullable = true)
	private int etat;

	@Column(nullable = true)
	private int genre;

	@OneToOne(fetch = FetchType.LAZY)
	private Adresse adresse;
	
	@OneToMany(mappedBy="client")
	private List<Panier> paniers;
	
	@OneToOne(mappedBy="client", fetch=FetchType.LAZY )
	private Paiement paiement;
>>>>>>> origin/Jean-Sebastien

	@Column(length = 10)
	private String telephone;
	
	@Column(nullable = true)
	private int etat;
	
	@Column(nullable = true)
	private int genre;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Adresse adresse;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Paiement> paiements = new ArrayList<>();
	
	@OneToOne(mappedBy = "client", fetch=FetchType.LAZY )
	private Panier panier;

	
	

	//Constructeurs
	public Client() {
	}

	public Client(Long id, String nom, String prenom, String mail, String nomSociete, String telephone, int etat,
			int genre, Adresse adresse) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMail(mail);
		this.setNomSociete(nomSociete);
		this.setTelephone(telephone);
		this.setEtat(etat);
		this.setGenre(genre);
		this.setAdresse(adresse);
	}

	public Client(String nom, String prenom, String mail, String nomSociete, String telephone, Adresse adresse) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMail(mail);
		this.setNomSociete(nomSociete);
		this.setTelephone(telephone);
		this.setEtat(etat);
		this.setGenre(genre);
		this.setAdresse(adresse);
	}

	/* Getters Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getNomSociete() + " - " + this.getMail() + " - " + this.getNom() + " "
				+ this.getPrenom() + " - " + this.telephone + " - " + this.getEtat() + " - " + this.getGenre() + " - "
				+ adresse.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(((Client) obj).getId() != this.id) {
			return false;
		}
		return true;
	}

	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
}
