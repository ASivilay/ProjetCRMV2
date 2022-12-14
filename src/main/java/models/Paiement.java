package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paiement")
public class Paiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private int numCarte;
	
	@Column(nullable = false, length = 4)
	private int codeConf;
	
	@Column(nullable = false, length = 255)
	private String banque;
	
	@ManyToOne( fetch = FetchType.LAZY )
	private Client client;
	
	
	
	
	//Constructeurs
	public Paiement() {
	}

	public Paiement(Long id, int numCarte, int codeConf, String banque, Client client) {
		this.setId(id);
		this.setNumCarte(numCarte);
		this.setCodeConf(codeConf);
		this.setBanque(banque);
		this.setClient(client);
	}

	public Paiement(int numCarte, int codeConf, String banque, Client client) {
		this.setNumCarte(numCarte);
		this.setCodeConf(codeConf);
		this.setBanque(banque);
		this.setClient(client);
	}

	/* Getters Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public int getCodeConf() {
		return codeConf;
	}

	public void setCodeConf(int codeConf) {
		this.codeConf = codeConf;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "[" + id + "] " + this.getNumCarte() + " - " + this.getCodeConf() + " - " + this.getBanque()	+ " - "+ client.toString();
	}

}
