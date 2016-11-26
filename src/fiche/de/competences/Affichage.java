package fiche.de.competences;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Affichage {
	
	public static String[] lireFiche(int code_isep, String nom_competence, String version) throws ParseException {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		String[] fiche = new String[4];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			String sql= "SELECT Note, Commentaire, Commentaire_prof, Commentaire_groupe FROM fiche_competences WHERE Code_ISEP=code_isep AND Nom_competence=nom_competence AND Version=version";
			
			rs= st.executeQuery(sql);
			
			while (rs.next()) {
				fiche[0] = Integer.toString(rs.getInt("Note"));
				fiche[1] = rs.getString("Commentaire");
		        fiche[2] = rs.getString("Commentaire_prof");
		        fiche[3] = rs.getString("Commentaire_groupe");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fiche;
	}
}
