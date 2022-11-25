package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Adresse;

public class AdresseAdapter implements JsonSerializer<Adresse> {

	public JsonElement serialize(Adresse adresse, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", adresse.getId());
		json.addProperty("rue", adresse.getRue());
		json.addProperty("ville", adresse.getVille());
		json.addProperty("pays", adresse.getPays());
		json.addProperty("codePostal", adresse.getCodePostal());

		return json;
	}

}
