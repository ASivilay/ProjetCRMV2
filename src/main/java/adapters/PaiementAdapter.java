package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Paiement;

public class PaiementAdapter implements JsonSerializer<Paiement> {

	@Override
	public JsonElement serialize(Paiement paiement, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", paiement.getId());
		json.addProperty("numCarte", paiement.getNumCarte());
		json.addProperty("codeConf", paiement.getCodeConf());
		json.addProperty("banque", paiement.getBanque());

		return json;
	}

}
