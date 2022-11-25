package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonSyntaxException;

import utils.Utils;
import services.ServiceException;
import services.ServiceProduit;

@WebServlet("/produitjson")
public class ProduitJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override // Recuperation d'un produit
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			String idProduit = req.getParameter("id");
			if (idProduit != null) {
				response = new ServiceProduit().find(Long.parseLong(idProduit));
			} else {
				response = new ServiceProduit().list();
			}
			contentType = "application/json";
		} catch (NumberFormatException e) {
			response = "Le paramètre id n'est pas bon.";
			responseStatus = 400;
		} catch (ServiceException e) {
			response = e.getMessage();
			responseStatus = 404;
		}

		resp.setContentType(contentType);
		resp.setStatus(responseStatus);
		resp.getWriter().write(response);
	}

	@Override // Création d'un produit
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			new ServiceProduit().create(Utils.getJsonFromBuffer(req));
		} catch (JsonSyntaxException e) {
			response = "Erreur : Le format des données n'est pas bon, veuillez utiliser du JSON.";
			responseStatus = 400;
		} catch (ServiceException e) {
			response = e.getMessage();
			responseStatus = 500;
		}

		resp.setContentType(contentType);
		resp.setStatus(responseStatus);
		resp.getWriter().write(response);
	}

	@Override // Modification d'un produit
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			new ServiceProduit().update(Utils.getJsonFromBuffer(req));
		} catch (JsonSyntaxException e) {
			response = "Erreur : Le format des données n'est pas bon, veuillez utiliser du JSON.";
			responseStatus = 400;
		} catch (ServiceException e) {
			response = e.getMessage();
			responseStatus = 500;
		}

		resp.setContentType(contentType);
		resp.setStatus(responseStatus);
		resp.getWriter().write(response);
	}

	@Override // Suppression d'un produit
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			String idProduit = req.getParameter("id");
			new ServiceProduit().delete(Long.parseLong(idProduit));
		} catch (NumberFormatException e) {
			response = "Le paramètre id n'est pas bon.";
			responseStatus = 400;
		} catch (ServiceException e) {
			response = "Erreur : " + e.getMessage();
			responseStatus = 500;
		}

		resp.setContentType(contentType);
		resp.setStatus(responseStatus);
		resp.getWriter().write(response);
	}
}
