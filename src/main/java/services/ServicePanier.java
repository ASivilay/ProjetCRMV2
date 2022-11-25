package services;

import com.google.gson.JsonObject;

import dao.DaoException;
import dao.impl.DaoClient;
import dao.impl.DaoPanier;
import models.Client;
import models.Panier;
import utils.Utils;

public class ServicePanier {

	DaoPanier daoPanier;
	DaoClient daoClient;

	public ServicePanier() {
		daoPanier = new DaoPanier();
		daoClient = new DaoClient();
	}

	public String find(long id) throws ServiceException {
		Panier panier;

		try {
			panier = daoPanier.find(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return Utils.getSuperJson().toJson(panier);
	}
	
	public String list() {
		return Utils.getSuperJson().toJson(daoPanier.list());
	}
	
	public void create(JsonObject data) throws ServiceException {

		try {
			// Récupération des informations depuis l'objet JSON
			String idclient = Utils.getStringParameter(data, "client_id", false, 1, 20);
			
			// Création
			Panier panier = new Panier();
			Client client = daoClient.find(Long.parseLong(idclient));
			panier.setClient(client);
			
			daoPanier.create(panier);
			
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void update(JsonObject data) throws ServiceException {
		try {

			// Récupération des informations depuis l'objet JSON
			String id = Utils.getStringParameter(data, "id", false, 1, 20);
			String idclient = Utils.getStringParameter(data, "client_id", false, 1, 20);
			
			// Création du panier
			Panier panier = daoPanier.find(Long.parseLong(id));
			Client client = daoClient.find(Long.parseLong(idclient));
			panier.setClient(client);
			
			daoPanier.update(panier);
			
		} catch (NumberFormatException e) {
			throw new ServiceException("Le format du paramètre id n'est pas bon.");
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void delete(long id) throws ServiceException {
		try {
			daoPanier.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
