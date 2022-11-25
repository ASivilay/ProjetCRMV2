package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String rue;
	
	@Column(nullable = false, length = 255)
	private String ville;
	
	@Column(nullable = false, length = 255)
	private String pays;
	
	@Column(nullable = false, length = 255)
	private String codePostal;
	
	
	@OneToOne(mappedBy = "adresse", fetch = FetchType.LAZY)
	private Client client;

	
	
	

	//Constructeurs
	public Adresse() {
	}

	public Adresse(Long id, String rue, String ville, String pays, String codePostal) {
		this.setId(id);
		this.setRue(rue);
		this.setVille(ville);
		this.setPays(pays);
		this.setCodePostal(codePostal);
	}

	public Adresse(String rue, String ville, String pays, String codePostal) {
		this.setRue(rue);
		this.setVille(ville);
		this.setPays(pays);
		this.setCodePostal(codePostal);
	}

	/* Getters Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getRue() + " " + this.getCodePostal() + " " + this.getVille() + " " + this.getPays();
	}
}
