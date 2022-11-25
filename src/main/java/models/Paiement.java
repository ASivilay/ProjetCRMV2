package models;

public class Paiement {

	private Long id;
	private int numCarte;
	private int codeConf;
	private String banque;;
	private Client client;

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
