package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Panier;

public class PanierAdapter implements JsonSerializer<Panier> {

	@Override
	public JsonElement serialize(Panier panier, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", panier.getId());
		json.addProperty("client_id", panier.getClient().getId());
		json.addProperty("client_nom", panier.getClient().getNom());
		json.addProperty("client_prenom", panier.getClient().getPrenom());

		return json;
	}

}
