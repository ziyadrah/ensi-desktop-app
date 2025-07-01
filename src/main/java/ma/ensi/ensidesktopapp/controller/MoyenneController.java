// Fichier : MoyenneController.java
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Moyenne;
import java.sql.*;

public class MoyenneController {
    private Connection conn;

    public MoyenneController(Connection conn) {
        this.conn = conn;
    }

    public void enregistrerMoyenne(Moyenne moyenne) throws SQLException {
        String sql = "INSERT INTO moyennes(code_eleve, code_filiere, niveau, moyenne) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, moyenne.getCodeEleve());
            stmt.setString(2, moyenne.getCodeFiliere());
            stmt.setString(3, moyenne.getNiveau());
            stmt.setDouble(4, moyenne.getMoyenne());
            stmt.executeUpdate();
        }
    }

    public Moyenne getMoyenneParEleve(String codeEleve) throws SQLException {
        String sql = "SELECT * FROM moyennes WHERE code_eleve = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeEleve);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Moyenne(
                            rs.getInt("id"),
                            rs.getString("code_eleve"),
                            rs.getString("code_filiere"),
                            rs.getString("niveau"),
                            rs.getDouble("moyenne")
                    );
                }
            }
        }
        return null;
    }
}
