package connexion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import isep.lab1.servlet.String;

@WebServlet("/Connexion")

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Connexion() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		
		boolean verif = Authentification.verifMDP(login, mdp);
		
		if (verif == true) {
			HttpSession s=request.getSession(true);
			String[] info = Authentification.recupInfos(login);
			s.setAttribute("CodeISEP", info[0]);
			s.setAttribute("Statut", info[1]);
			s.setAttribute("Classe", info[2]);
			s.setAttribute("Groupe", info[3]);
		}
	}

}
