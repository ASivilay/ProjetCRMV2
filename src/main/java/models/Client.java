package models;

public class Client {

	private Long id;
	private String nom;
	private String prenom;
	private String mail;
	private String nomSociete;
	private String telephone;
	private int etat;
	private int genre;
	private Adresse adresse;

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

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getNomSociete() + " - " + this.getMail() + " - " + this.getNom() + " " + this.getPrenom() + " - " + this.telephone + " - " + this.getEtat() + " - " + this.getGenre() + " - " + adresse.toString();
	}
}
