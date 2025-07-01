package ma.ensi.ensidesktopapp.service;

import ma.ensi.ensidesktopapp.dao.EleveDAO;
import ma.ensi.ensidesktopapp.model.Eleve;

import java.sql.SQLException;
import java.util.List;

public class EleveService {

    private final EleveDAO dao = new EleveDAO();

    public void addEleve(Eleve student) throws SQLException {
        // Exemple de validation
        if (student.getCode().isEmpty()) throw new IllegalArgumentException("Le code est requis.");
        dao.insert(student);
    }

    public void updateStudent(Eleve student) throws SQLException {
        if (student.getId() <= 0) throw new IllegalArgumentException("ID invalide.");
        dao.update(student);
    }

    public List<Eleve> getAllEleves() throws SQLException {
        return dao.getAll();
    }
}
