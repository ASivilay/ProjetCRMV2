package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonSyntaxException;

import services.ServiceContient;
import services.ServiceException;
import utils.Utils;

@WebServlet("/contientjson")
public class ContientJsonServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContientJsonServlet() {
        super();
    }


	@Override // Recuperation d'un panier
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			String idContient = req.getParameter("id");
			if (idContient != null) {
				response = new ServiceContient().find(Long.parseLong(idContient));
			} else {
				response = new ServiceContient().list();
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

	@Override // Création d'un panier
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			new ServiceContient().create(Utils.getJsonFromBuffer(req));
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
	
	@Override // Modification d'un panier
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		int responseStatus = 200;
		String response = "Ok";
		String contentType = "text";

		try {
			new ServiceContient().update(Utils.getJsonFromBuffer(req));
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
			String idContient = req.getParameter("id");
			new ServiceContient().delete(Long.parseLong(idContient));
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
