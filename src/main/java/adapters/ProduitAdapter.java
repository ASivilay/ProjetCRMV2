package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import models.Produit;

public class ProduitAdapter implements JsonSerializer<Produit>{

	@Override
	public JsonElement serialize(Produit produit, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject json = new JsonObject();
		json.addProperty("id", produit.getId());
		json.addProperty("nom", produit.getNom());
		json.addProperty("description", produit.getDescription());
		json.addProperty("prix", produit.getPrix());
		
		return json;
	}

}
