package services;

import com.google.gson.JsonObject;

import dao.DaoException;
import utils.Utils;
import dao.impl.DaoProduit;
import models.Produit;

public class ServiceProduit {

	DaoProduit daoProduit;

	public ServiceProduit() {
		daoProduit = new DaoProduit();
	}

	public String find(long id) throws ServiceException {
		Produit produit;

		try {
			produit = daoProduit.find(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return Utils.getSuperJson().toJson(produit);
	}
	
	public String list() {
		return Utils.getSuperJson().toJson(daoProduit.list());
	}
	
	public void create(JsonObject data) throws ServiceException {

		try {
			// Récupération des informations de l'auteur depuis l'objet JSON
			String nom = Utils.getStringParameter(data, "nom", false, 2, 255);
			String description = Utils.getStringParameter(data, "description", true, 1, 255);
			String prix = Utils.getStringParameter(data, "prix", true, 0, 20);
			
			float prixfinal = Float.parseFloat(prix);
			
			// Création de l'auteur
			Produit produit = new Produit();
			produit.setNom(nom);
			produit.setDescription(description);
			produit.setPrix(prixfinal);
			
			daoProduit.create(produit);
			
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void update(JsonObject data) throws ServiceException {
		try {

			// Récupération des informations de l'auteur depuis l'objet JSON
			String id = Utils.getStringParameter(data, "id", false, 0, 50);
			String nom = Utils.getStringParameter(data, "nom", false, 2, 255);
			String description = Utils.getStringParameter(data, "description", true, 1, 255);
			String prix = Utils.getStringParameter(data, "prix", true, 0, 20);

			float prixfinal = Float.parseFloat(prix);
			
			// Création de l'auteur
			Produit produit = daoProduit.find(Long.parseLong(id));
			produit.setNom(nom);
			produit.setDescription(description);
			produit.setPrix(prixfinal);
			
			daoProduit.update(produit);
			
		} catch (NumberFormatException e) {
			throw new ServiceException("Le format du paramètre id n'est pas bon.");
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void delete(long id) throws ServiceException {
		try {
			daoProduit.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
