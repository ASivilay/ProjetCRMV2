package models;

public class Contient {

	private Long id;
	private Produit produit;
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

}
