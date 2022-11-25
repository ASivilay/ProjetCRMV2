package services;

import com.google.gson.JsonObject;

import dao.DaoException;
import dao.impl.DaoClient;
import dao.impl.DaoContient;
import dao.impl.DaoPanier;
import dao.impl.DaoProduit;
import models.Client;
import models.Contient;
import models.Panier;
import models.Produit;
import utils.Utils;

public class ServiceContient {

	DaoContient daoContient;
	DaoPanier daoPanier;
	DaoProduit daoProduit;
	
	public ServiceContient() {
		daoContient = new DaoContient();
		daoPanier = new DaoPanier();
		daoProduit = new DaoProduit();
	}

	public String find(long id) throws ServiceException {
		Contient contient;

		try {
			contient = daoContient.find(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return Utils.getSuperJson().toJson(contient);
	}
	
	public String list() {
		return Utils.getSuperJson().toJson(daoContient.list());
	}
	
	
	public void create(JsonObject data) throws ServiceException {

		try {
			// Récupération des informations de l'auteur depuis l'objet JSON
			String idproduit = Utils.getStringParameter(data, "produit_id", false, 1, 20);
			String idpanier = Utils.getStringParameter(data, "panier_id", false, 1, 20);
			
			// Création de l'auteur
			Panier panier = daoPanier.find(Long.parseLong(idpanier));
			Produit produit = daoProduit.find(Long.parseLong(idproduit));
			Contient contient = new Contient(produit, panier);
			
			daoContient.create(contient);
			
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void update(JsonObject data) throws ServiceException {
		try {

			// Récupération des informations de l'auteur depuis l'objet JSON
			String id = Utils.getStringParameter(data, "id", false, 1, 20);
			String idproduit = Utils.getStringParameter(data, "produit_id", false, 1, 20);
			
			// Création de l'auteur
			Contient contient = daoContient.find(Long.parseLong(id));
			Produit produit = daoProduit.find(Long.parseLong(idproduit));
			contient.setProduit(produit);
			
			daoContient.update(contient);
			
		} catch (NumberFormatException e) {
			throw new ServiceException("Le format du paramètre id n'est pas bon.");
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void delete(long id) throws ServiceException {
		try {
			daoContient.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
