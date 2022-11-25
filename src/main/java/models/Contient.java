package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contient")
public class Contient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name="produit_id", nullable=false)
	private Produit produit;
	
    @ManyToOne
    @JoinColumn(name="panier_id", nullable=false)
	private Panier panier;

	public Contient() {
	}

	public Contient(Long id, Produit produit, Panier panier) {
		this.setId(id);
		this.setProduit(produit);
		this.setPanier(panier);
	}

	public Contient(Produit produit, Panier panier) {
		this.setProduit(produit);
		this.setPanier(panier);
	}

	/* Getters Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getProduit() + " - " + this.getPanier();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(((Contient) obj).getId() != this.id) {
			return false;
		}
		return true;
	}
}
