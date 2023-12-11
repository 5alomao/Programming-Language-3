package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelException;
import model.User;
import model.dao.DAOFactory;
import model.dao.UserDAO;

// ROTAS
@WebServlet(urlPatterns = { "", "/save" })
public class UsersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		switch (uri) {
		case "/facebook/": {

			// Carregar usuários
			loadUsers(req);

			// Direcionar a chamada para a index.html
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			// Enviando req e resposta
			rd.forward(req, resp);

			break;

		}
		case "/facebook/save": {

			insertUser(req);
			resp.sendRedirect("/facebook/");
			break;
		}
		default:
			PrintWriter writer = resp.getWriter();
			writer.append("404 recurso não encontrado: " + uri);
		}
	}

	private void insertUser(HttpServletRequest req) {

		// Pega os dados do formulário
		String userName = req.getParameter("user-name");
		String userGender = req.getParameter("user-gender");
		String userEmail = req.getParameter("user-email");

		// Criar um objeto do tipo User e setar os daddos
		User objUser = new User();
		objUser.setName(userName);
		objUser.setGender(userGender);
		objUser.setEmail(userEmail);

		// Criar um DAO e salvar o objeto
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);

		try {
			dao.save(objUser);
		} catch (ModelException e) {
			e.printStackTrace();
		}
	}

	private void loadUsers(HttpServletRequest req) {

		// Criar um DAO
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);

		// Recuperar os usuários em uma lista
		List<User> users = null;

		try {
			users = dao.listAll();
		} catch (ModelException e) {
			e.printStackTrace();
		}

		// Deixar uma lista disponível para ser acessada.
		req.setAttribute("usersList", users);

	}

}
