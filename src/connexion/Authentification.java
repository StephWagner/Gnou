package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentification {

	public static boolean verifMDP (String login, String mdp) {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		boolean verif = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			PreparedStatement preparedStatement	= cn.prepareStatement("SELECT Mdp FROM profil WHERE Login=? " );
			preparedStatement.setString( 1, login );
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				if (mdp.equals(rs.getString("Mdp"))) { verif=true; }
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
		return verif;
	}
	
	public static String[] recupInfos(String login) {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		String[] infos = new String[5];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			
			PreparedStatement preparedStatement	= cn.prepareStatement("SELECT Code_ISEP, Prenom, Statut, Groupe FROM profil WHERE Login=? " );
			preparedStatement.setString( 1, login );
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				infos[0] = Integer.toString(rs.getInt("Code_ISEP"));
				infos[1] = rs.getString("Statut");
		        infos[2] = rs.getString("Groupe");
		        infos[3] = rs.getString("Prenom");
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
		return infos;
	}
	
}
