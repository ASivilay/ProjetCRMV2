package adapters;

import java.lang.reflect.Type;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Client;
import models.Paiement;

public class ClientAdapter implements JsonSerializer<Client> {

	@Override
	public JsonElement serialize(Client client, Type typeOfSrc, JsonSerializationContext context) {

		// Paiement

		JsonObject json = new JsonObject();

		json.addProperty("id", client.getId());
		json.addProperty("nom", client.getNom());
		json.addProperty("prenom", client.getPrenom());
		json.addProperty("mail", client.getMail());
		json.addProperty("telephone", client.getTelephone());
		json.addProperty("etat", client.getEtat());
		json.addProperty("genre", client.getGenre());

		JsonArray paiementsJson = new JsonArray();
		// tmp c'est l'iterateur
		JsonObject tmp;
		for (Paiement p : client.getPaiements()) {
			tmp = new JsonObject();
			tmp.addProperty("id", p.getId());
			paiementsJson.add(tmp);
		}

		json.add("paiements", paiementsJson);

		// Adresse
		JsonObject adresseJson = null;
		if (client.getAdresse() != null) {
			adresseJson = new JsonObject();
			adresseJson.addProperty("id", client.getAdresse().getId());
			adresseJson.addProperty("rue", client.getAdresse().getRue());
			adresseJson.addProperty("ville", client.getAdresse().getVille());
			adresseJson.addProperty("codePostal", client.getAdresse().getCodePostal());
		}

		json.add("adresse", adresseJson);

		// Panier

		JsonObject panierJson = null;
		if (client.getPanier() != null) {
			panierJson = new JsonObject();
			panierJson.addProperty("id", client.getPanier().getId());
		}

		json.add("panier", panierJson);

		return json;
	}
}
