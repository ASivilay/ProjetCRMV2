package services;

import com.google.gson.JsonObject;

import dao.DaoException;
import dao.impl.DaoAdresse;
import dao.impl.DaoClient;
import models.Adresse;
import models.Client;
import utils.Utils;

public class ServiceAdresse {

	DaoAdresse daoAdresse;
	DaoClient daoClient;

	public ServiceAdresse() {
		daoAdresse = new DaoAdresse();
		daoClient = new DaoClient();
	}

	public String find(long id) throws ServiceException {
		Adresse adresse;

		try {
			adresse = daoAdresse.find(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		if (adresse == null)
			throw new ServiceException("L'adresse n'existe pas. Id: " + id);
		return Utils.getSuperJson().toJson(adresse);
	}

	public String list() {
		return Utils.getSuperJson().toJson(daoAdresse.list());
	}

	public void create(JsonObject data) throws ServiceException {

		String rue = null;
		String pays = null;
		String ville = null;
		String codePostal = null;
		String idClient = null;
		Client client = null;

		try {
			pays = Utils.getStringParameter(data, "paysAdresse", false, 2, 255);
			ville = Utils.getStringParameter(data, "villeAdresse", false, 2, 255);
			rue = Utils.getStringParameter(data, "rueAdresse", false, 2, 255);
			codePostal = Utils.getStringParameter(data, "codePostalAdresse", false, 2, 255);

			idClient = Utils.getStringParameter(data, "idCient", true, 0, 50, "^\\d+$");

			if (idClient != null) {
				client = daoClient.find(Long.parseLong(idClient));
				if (client == null)
					throw new ServiceException("Le client n'existe pas. Id : " + idClient);

				if (client.getAdresse() != null)
					throw new ServiceException(
							"Le client est déja associé a l'adresse d'id : " + client.getAdresse().getId());
			}

			Adresse adresse = new Adresse();
			adresse.setRue(rue);
			adresse.setVille(ville);
			adresse.setPays(pays);
			adresse.setCodePostal(codePostal);
			adresse.setClient(client);

			daoAdresse.create(adresse);

			if (client != null) {
				client.setAdresse(adresse);
				daoClient.update(client);
			}
		} catch (DaoException e) {
			throw new ServiceException("Erreur DAO.");
		}
	}

	public void update(JsonObject data) throws ServiceException {
		String id = null;
		String rue = null;
		String ville = null;
		String pays = null;
		String codePostal = null;

		String idClient = null;
		Client client = null;

		try {
			id = Utils.getStringParameter(data, "idAdresse", false, 0, 50, "^\\d+$");
			rue = Utils.getStringParameter(data, "rueAdresse", false, 2, 255);
			ville = Utils.getStringParameter(data, "ville", false, 0, 50);
			pays = Utils.getStringParameter(data, "pays", false, 0, 50);
			codePostal = Utils.getStringParameter(data, "codePostal", false, 0, 50);
			idClient = Utils.getStringParameter(data, "client", false, 0, 50, "^\\d+$");

			Adresse adresse = daoAdresse.find(Long.parseLong(id));
			if (adresse == null)
				throw new ServiceException("L'adresse n'existe pas. Id : " + id);

			if (idClient != null) {
				client = daoClient.find(Long.parseLong(idClient));
				if (client == null)
					throw new ServiceException("Le client n'existe pas. Id : " + idClient);

				if (client.getAdresse() != null && client.getAdresse().getId() != Long.parseLong(id))
					throw new ServiceException(
							"L'adresse est déja associée au client d'id : " + client.getAdresse().getId());
			} else {
				if (adresse.getClient() != null) {
					Client clientOld = adresse.getClient();
					clientOld.setAdresse(null);
					daoClient.update(clientOld);
				}
			}

			adresse.setRue(rue);
			adresse.setVille(ville);
			adresse.setPays(pays);
			adresse.setCodePostal(codePostal);
			adresse.setClient(client);

			daoAdresse.update(adresse);

			if (client != null) {
				client.setAdresse(adresse);
				daoClient.update(client);
			}
		} catch (NumberFormatException e) {
			throw new ServiceException("Le format du paramètre idAdresse n'est pas bon.");
		} catch (DaoException e) {
			throw new ServiceException("Erreur DAO.");
		}
	}

	public void delete(long id) throws ServiceException {
		try {
			daoAdresse.delete(id);
		} catch (DaoException e) {
			throw new ServiceException("L'adresse n'existe pas. Id : " + id);
		}
	}
}
