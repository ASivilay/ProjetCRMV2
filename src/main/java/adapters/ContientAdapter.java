package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Contient;

public class ContientAdapter  implements JsonSerializer<Contient> {

	@Override
	public JsonElement serialize(Contient contient, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", contient.getId());
		json.addProperty("panier_id", contient.getPanier().getId());
		json.addProperty("produit_id", contient.getProduit().getId());
		json.addProperty("produit_nom", contient.getProduit().getNom());
		json.addProperty("produit_prix", contient.getProduit().getPrix());

		return json;
	}

}
