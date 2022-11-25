package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import adapters.ContientAdapter;
import adapters.PanierAdapter;
import adapters.ProduitAdapter;
import models.Contient;
import models.Panier;
import models.Produit;
import services.ServiceException;

public class Utils {

	public static String VALEUR_NULL = "(NULL)";

	public static Gson getSuperJson() {
		GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Produit.class, new ProduitAdapter())
				.registerTypeAdapter(Panier.class, new PanierAdapter())
				.registerTypeAdapter(Contient.class, new ContientAdapter())
				.serializeNulls();

		return gsonBuilder.create();
	}

	public static JsonObject getJsonFromBuffer(HttpServletRequest request) throws IOException, JsonSyntaxException {
		// Récupération du body de la requête sous forme de String
		StringBuffer buffer = new StringBuffer();
		String line = null, body = "";
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		body = buffer.toString();

		// Récupération d'un objet JAVA représentant un JSON
		JsonObject data = JsonParser.parseString(body).getAsJsonObject();

		return data;
	}

	public static String getStringParameter(JsonObject data, String nameField, boolean isNullable, int minLength,
			int maxLength) throws ServiceException {
		String parameter = null;

		if (data.get(nameField) != null && !data.get(nameField).isJsonNull()) {
			parameter = data.get(nameField).getAsString().trim();

			if (parameter.length() < minLength) {
				throw new ServiceException(
						"Le champ " + nameField + " doit contenir au moins " + minLength + " caractères.");
			}

			if (parameter.length() > maxLength) {
				throw new ServiceException(
						"Le champ " + nameField + " doit contenir au maximum " + maxLength + " caractères.");
			}
		}

		if (!isNullable && parameter == null) {
			throw new ServiceException("Le champ " + nameField + " est obligatoire.");
		}

		return parameter;
	}

	public static String getStringParameter(JsonObject data, String nameField, boolean isNullable, int minLength,
			int maxLength, String regexFormat) throws ServiceException {
		String parameter = getStringParameter(data, nameField, isNullable, minLength, maxLength);

		if (parameter != null) {
			if (!parameter.matches(regexFormat)) {
				throw new ServiceException("Le champ " + nameField + " n'a pas un format valide.");
			}
		}

		return parameter;
	}

	// --------------------------------------------
	// Partie perso
	// --------------------------------------------

	public static StringBuffer bufferiser(HttpServletRequest req) throws IOException {
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = req.getReader().readLine()) != null) {
			buffer.append(line);
		}

		return buffer;
	}

	public static String checkKey(Set<String> s, String[] tab) {
		String retour = "";
		for (String param : tab) {
			if (!s.contains(param))
				retour += "Clef [" + param + "] absente\n";
		}
		return retour;
	}

}
