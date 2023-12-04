import model.ModelException;
import model.User;
import model.dao.UserDAO;
import model.dao.MySQLUserDAO;

public class JDBCTest {

	public static void main(String[] args) throws ModelException {
		User salomao = new User();
		salomao.setName("Salomão");
		salomao.setEmail("salomao@gmail.com");
		salomao.setGender("M");

		// lado esquerdo classe abstrata, lado direito implementação
		UserDAO userDAO = new MySQLUserDAO();
		userDAO.save(salomao);
	}
}