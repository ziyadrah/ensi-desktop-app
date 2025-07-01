// Fichier : ModuleController.java
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Module;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleController {
    private Connection conn;

    public ModuleController(Connection conn) {
        this.conn = conn;
    }

    public List<Module> listerModulesParFiliere(String codeFiliere) throws SQLException {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM module WHERE code_filiere = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeFiliere);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Module mod = new Module(
                            rs.getInt("id"),
                            rs.getString("code"),
                            rs.getString("designation"),
                            rs.getString("niveau"),
                            rs.getInt("semestre"),
                            rs.getString("code_filiere")
                    );
                    modules.add(mod);
                }
            }
        }
        return modules;
    }
}
