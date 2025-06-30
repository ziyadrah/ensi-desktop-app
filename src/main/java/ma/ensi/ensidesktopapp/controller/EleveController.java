// Fichier : StudentController.java
// (inchangé)
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Eleve;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveController {
    private Connection conn;

    public EleveController(Connection conn) {
        this.conn = conn;
    }

    public void ajouterEleve(Eleve eleve) throws SQLException {
        String sql = "INSERT INTO Eleve(code, nom, prenom, niveau, code_filiere) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eleve.getCode());
            stmt.setString(2, eleve.getNom());
            stmt.setString(3, eleve.getPrenom());
            stmt.setString(4, eleve.getNiveau());
            stmt.setString(5, eleve.getCodeFiliere());
            stmt.executeUpdate();
        }
    }

    public List<Eleve> listerEleves() throws SQLException {
        List<Eleve> eleves = new ArrayList<>();
        String sql = "SELECT * FROM Eleve";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Eleve e = new Eleve(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("niveau"),
                        rs.getString("code_filiere")
                );
                eleves.add(e);
            }
        }
        return eleves;
    }

    public void modifierEleve(Eleve eleve) throws SQLException {
        String sql = "UPDATE Eleve SET nom = ?, prenom = ?, niveau = ?, code_filiere = ? WHERE code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eleve.getNom());
            stmt.setString(2, eleve.getPrenom());
            stmt.setString(3, eleve.getNiveau());
            stmt.setString(4, eleve.getCodeFiliere());
            stmt.setString(5, eleve.getCode());
            stmt.executeUpdate();
        }
    }

    public void supprimerEleve(String code) throws SQLException {
        String sql = "DELETE FROM Eleve WHERE code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.executeUpdate();
        }
    }

    public Eleve chercherEleveParCode(String code) throws SQLException {
        String sql = "SELECT * FROM Eleve WHERE code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Eleve(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("niveau"),
                            rs.getString("code_filiere")
                    );
                }
            }
        }
        return null;
    }
}
