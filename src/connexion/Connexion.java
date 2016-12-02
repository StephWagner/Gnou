package connexion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Connexion")

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Connexion() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		String url="";
		if (s.isNew()) {
			url = "/index.html";
		}
		else {
			String login = (String) s.getAttribute("login");
			String[] info = Authentification.recupInfos(login);
			int code_isep = Integer.parseInt(info[0]);
			String statut = info[1];
			String classe = info[2];
			int groupe = Integer.parseInt(info[3]);
			
			Person personBean = new Person(code_isep, statut, classe, groupe);
			request.setAttribute("person",personBean);
			
			url = "/fichedecompetences.jsp";
		}
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		
		boolean verif = Authentification.verifMDP(login, mdp);
		
		String url="";
		
		if (verif == true) {
			HttpSession s=request.getSession(true);
			s.setAttribute("login", login);
			String[] info = Authentification.recupInfos(login);
			int code_isep = Integer.parseInt(info[0]);
			String statut = info[1];
			String classe = info[2];
			int groupe = Integer.parseInt(info[3]);
			
			Person personBean = new Person(code_isep, statut, classe, groupe);
			request.setAttribute("person",personBean);
			
			url = "/fichedecompetences.jsp";
		}	
		else {
			url = "/index.html";
		}
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
		dispatcher.include(request, response);
	}

}
