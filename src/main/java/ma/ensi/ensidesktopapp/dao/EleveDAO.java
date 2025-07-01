package ma.ensi.ensidesktopapp.dao;

import ma.ensi.ensidesktopapp.idao.IEleveDAO;
import ma.ensi.ensidesktopapp.model.Eleve;
import ma.ensi.ensidesktopapp.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveDAO implements IEleveDAO {

    @Override
    public void insert(Eleve student) throws SQLException {
        String sql = "CALL insert_eleve(?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getCode());
            stmt.setString(2, student.getNom());
            stmt.setString(3, student.getPrenom());
            stmt.setInt(4, student.getNiveau());
            stmt.setInt(5, student.getCodeFiliere());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Eleve student) throws SQLException {
        String sql = "CALL update_eleve(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getCode());
            stmt.setString(3, student.getNom());
            stmt.setString(4, student.getPrenom());
            stmt.setInt(5, student.getNiveau());
            stmt.setInt(6, student.getCodeFiliere());
            stmt.execute();
        }
    }

    @Override
    public List<Eleve> getAll() throws SQLException {
        List<Eleve> list = new ArrayList<>();
        String sql = "SELECT * FROM Eleve";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Eleve s = new Eleve(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("niveau"),
                        rs.getInt("code_filiere")
                );
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public Eleve findById(int id) throws SQLException {
        String sql = "SELECT * FROM Eleve WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Eleve(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("niveau"),
                        rs.getInt("code_filiere")
                );
            }
        }
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "CALL delete_eleve(?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
