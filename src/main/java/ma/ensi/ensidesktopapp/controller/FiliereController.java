// Fichier : FiliereController.java
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Filiere;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiliereController {
    private Connection conn;

    public FiliereController(Connection conn) {
        this.conn = conn;
    }

    public List<Filiere> listerFilieres() throws SQLException {
        List<Filiere> filieres = new ArrayList<>();
        String sql = "SELECT * FROM filiere";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Filiere fil = new Filiere(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("designation")
                );
                filieres.add(fil);
            }
        }
        return filieres;
    }

    public Filiere chercherFiliereParCode(String code) throws SQLException {
        String sql = "SELECT * FROM filiere WHERE code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Filiere(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("designation")
                    );
                }
            }
        }
        return null;
    }

    public void ajouterFiliere(Filiere filiere) throws SQLException {
        String sql = "INSERT INTO filiere(code, designation) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filiere.getCode());
            stmt.setString(2, filiere.getDesignation());
            stmt.executeUpdate();
        }
    }

    public void supprimerFiliereParCode(String code) throws SQLException {
        String sql = "DELETE FROM filiere WHERE code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.executeUpdate();
        }
    }
} 