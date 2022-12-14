package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String nom;
	
	@Column
	private String description;
	
	@Column()
	private float prix;

	
	@ManyToMany(mappedBy = "produits")
	private List<Panier> paniers = new ArrayList<>();
	
	
	
	

	/* Constructeurs */
	public Produit() {
	}

	public Produit(Long id, String nom, String description, float prix) {
		this.setId(id);
		this.setNom(nom);
		this.setDescription(description);
		this.setPrix(prix);
	}

	public Produit(String nom, String description, float prix) {
		this.setNom(nom);
		this.setDescription(description);
		this.setPrix(prix);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}
	
	public void addProduit(Panier panier) {
		this.paniers.add(panier);
		panier.getProduits().add(this);
	}
	
	public void removeProduit(Panier panier) {
		this.paniers.remove(panier);
		panier.getProduits().remove(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getNom() + " - " + this.getDescription() + " - " + this.getPrix();
	}
}
