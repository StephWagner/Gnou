package fiche_competence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Affichage {
	
	public ArrayList<String> lireFiche(int code_isep, String nom_competence, int version) throws ParseException {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		ArrayList<String> fiche = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			String sql= "SELECT Note, Commentaire, Commentaire_prof FROM fiche_competences_eleve WHERE Code_ISEP="+code_isep+" AND Nom_competence=nom_competence AND ID_version="+version+"";
			
			rs= st.executeQuery(sql);
			
			while (rs.next()) {
				fiche.add(Integer.toString(rs.getInt("Note")));
				fiche.add(rs.getString("Commentaire"));
		        fiche.add(rs.getString("Commentaire_prof"));
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
	
	public int[] getMembre (String groupe) {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		int[] membre = new int[2];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			String sql= "SELECT Code_ISEP FROM profil WHERE Groupe=groupe";
			
			rs= st.executeQuery(sql);
			int i = 0;
			
			while (rs.next()) {
				membre[i] = rs.getInt("Code_ISEP");
				i++;
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
		return membre;
	}

	public String getPrenom(int code_isep) {
		
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		String prenom= new String();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			st = cn.createStatement();
			String sql= "SELECT Prenom FROM profil WHERE Code_ISEP="+code_isep+"";
			
			rs= st.executeQuery(sql);
			
			while (rs.next()) {
				prenom = rs.getString("Prenom");
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
		return prenom;
}
	
}

