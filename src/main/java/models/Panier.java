package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
	private Client client;

    @OneToMany(mappedBy="panier")
    private List<Contient> contients;
    
    
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
	
	@Override
	public boolean equals(Object obj) {
		if(((Panier) obj).getId() != this.id) {
			return false;
		}
		return true;
	}

	public List<Contient> getContients() {
		return contients;
	}

	public void setContients(List<Contient> contients) {
		this.contients = contients;
	}
}
