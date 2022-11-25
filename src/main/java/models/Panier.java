package models;

import java.util.ArrayList;
import java.util.List;

import models.Client;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	private Client client;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "contient", joinColumns = { @JoinColumn(name = "id_panier") }, inverseJoinColumns = {
			@JoinColumn(name = "id_produit") })
	private List<Produit> produits = new ArrayList<>();

	@OneToMany(mappedBy = "panier")
	private List<Contient> contients;

	// Constructeurs
	public Panier() {
	}

	public Panier(Long id, Client client) {
		this.setId(id);
		this.setClient(client);
	}

	public Panier(Client client) {
		this.setClient(client);
	}

	/* Getters Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

	public List<Contient> getContients() {
		return contients;
	}

	public void setContients(List<Contient> contients) {
		this.contients = contients;
	}

	public void addPanier(Produit produit) {
		this.produits.add(produit);
		produit.getPaniers().add(this);
	}

	public void removePanier(Produit produit) {
		this.produits.remove(produit);
		produit.getPaniers().remove(this);
	}

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getClient();
	}
}
