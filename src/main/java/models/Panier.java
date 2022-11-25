package models;

public class Panier {

	private Long id;
	private Client client;

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

	@Override
	public String toString() {
		return "[" + this.getId() + "] " + this.getClient();
	}
}
