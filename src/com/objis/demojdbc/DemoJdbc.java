package com.objis.demojdbc;

import java.sql.Connection;
import fiche.de.competences.Affichage;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class DemoJdbc {

	public static void main(String[] args) throws ParseException {
		String[] fiche = Affichage.lireFiche(9644,"Echanger", "2016-11-25 00:00:00");
		System.out.println("Note " + fiche[0] + " Commentaire " + fiche[1]);
		}

	public static void sauverEnBase() {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);

			st = cn.createStatement();
			String sql= "INSERT INTO `absence`(`date_absence`, `presence`, `code_isep`) VALUES ('2016-11-22','P','9579')";

			st.executeUpdate(sql);
			System.out.println("La ligne a bien �t� ajout� !");
			
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
}}
	
	public static void lireEnBase() {
		String DBURL = "jdbc:mysql://localhost/gnou?autoReconnect=true&useSSL=false";
		String DBLOGIN = "root";
		String DBPASSWORD = "root";
		
		Connection cn =null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);

			st = cn.createStatement();
			String sql= "SELECT * FROM absence";

			rs= st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getInt("ID_absence"));
				System.out.println(rs.getString("presence"));
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
}}}