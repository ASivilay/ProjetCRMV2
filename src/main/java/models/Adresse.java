package models;

public class Adresse {

	private Long id;
	private String rue;
	private String ville;
	private String pays;
	private String codePostal;

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

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getRue() + " " + this.getCodePostal() + " " + this.getVille() + " " + this.getPays();
	}
}
