// Fichier : NoteController.java
package ma.ensi.ensidesktopapp.controller;

import ma.ensi.ensidesktopapp.model.Note;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteController {
    private Connection conn;

    public NoteController(Connection conn) {
        this.conn = conn;
    }

    public void ajouterNote(Note note) throws SQLException {
        String sql = "INSERT INTO Notes(code_eleve, code_mat, note) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, note.getCodeEleve());
            stmt.setString(2, note.getCodeMatiere());
            stmt.setDouble(3, note.getNote());
            stmt.executeUpdate();
        }
    }

    public List<Note> listerNotesParEleve(String codeEleve) throws SQLException {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM Notes WHERE code_eleve = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeEleve);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Note note = new Note(
                            rs.getInt("id"),
                            rs.getString("code_eleve"),
                            rs.getString("code_mat"),
                            rs.getDouble("note")
                    );
                    notes.add(note);
                }
            }
        }
        return notes;
    }

    public void supprimerNoteParMatiere(String codeEleve, String codeMatiere) throws SQLException {
        String sql = "DELETE FROM Notes WHERE code_eleve = ? AND code_mat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeEleve);
            stmt.setString(2, codeMatiere);
            stmt.executeUpdate();
        }
    }

    public double calculerMoyenne(String codeEleve) throws SQLException {
        double moyenne = 0.0;
        String sql = "SELECT AVG(note) as moyenne FROM Notes WHERE code_eleve = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codeEleve);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    moyenne = rs.getDouble("moyenne");
                }
            }
        }
        return moyenne;
    }
}
