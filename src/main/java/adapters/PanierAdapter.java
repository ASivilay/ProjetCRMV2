package adapters;

<<<<<<< HEAD
public class PanierAdapter {
=======
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import dao.DaoException;
import dao.impl.DaoPanier;
import models.Contient;
import models.Panier;

public class PanierAdapter implements JsonSerializer<Panier> {

	@Override
	public JsonElement serialize(Panier panier, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", panier.getId());
		json.addProperty("client_id", panier.getClient().getId());
		json.addProperty("client_nom", panier.getClient().getNom());
		json.addProperty("client_prenom", panier.getClient().getPrenom());

		try {
			JsonArray jsonContients = new JsonArray();
			DaoPanier daoPanier = new DaoPanier();
			JsonObject jsonC = null;
			List<Contient> listContients = daoPanier.find(panier.getId()).getContients();
			for (Contient c : listContients) {
				jsonC = new JsonObject();
				jsonC.addProperty("id", c.getId());
				jsonC.addProperty("produit_id", c.getProduit().getId());
				jsonC.addProperty("produit_nom", c.getProduit().getNom());
				jsonC.addProperty("produit_prix", c.getProduit().getPrix());

				jsonContients.add(jsonC);
			}

			json.add("contient", jsonContients);

		} catch (DaoException d) {
			d.printStackTrace();
		}

		return json;
	}
>>>>>>> origin/Jean-Sebastien

}
