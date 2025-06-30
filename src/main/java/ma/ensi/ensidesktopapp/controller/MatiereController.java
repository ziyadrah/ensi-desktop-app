// Fichier : MatiereController.java
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Matiere;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatiereController {
    private Connection conn;

    public MatiereController(Connection conn) {
        this.conn = conn;
    }

    public List<Matiere> listerMatieresParModule(String codeModule) throws SQLException {
        List<Matiere> matieres = new ArrayList<>();
        String sql = "SELECT * FROM Matiere WHERE code_module = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeModule);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Matiere mat = new Matiere(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("designation"),
                            rs.getInt("VH"),
                            rs.getString("code_module")
                    );
                    matieres.add(mat);
                }
            }
        }
        return matieres;
    }

    public List<Matiere> listerMatieresParFiliereEtNiveau(String codeFiliere, String niveau) throws SQLException {
        List<Matiere> matieres = new ArrayList<>();
        String sql = "SELECT m.* FROM Matiere m JOIN Module mo ON m.code_module = mo.code WHERE mo.code_fil = ? AND mo.niveau = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeFiliere);
            stmt.setString(2, niveau);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Matiere mat = new Matiere(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("designation"),
                            rs.getInt("VH"),
                            rs.getString("code_module")
                    );
                    matieres.add(mat);
                }
            }
        }
        return matieres;
    }
}
