/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Jdbc;
import modele.metier.Utilisateur;

/**
 *
 * @author Unknow
 */
public class DaoUtilisateur {
    public static Utilisateur selectUtilById(String pseudo) throws SQLException {
        
        Utilisateur unUtilisateur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id,login,motDePasse,nom,prenom FROM `Utilisateur` WHERE login=\""+pseudo + "\"";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String login = rs.getString("login");
            String motDePasse = rs.getString("motDePasse");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            unUtilisateur = new Utilisateur(id,login,motDePasse,nom,prenom);
        }
        return unUtilisateur;
    }
}
