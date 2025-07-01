package ma.ensi.ensidesktopapp.idao;

import ma.ensi.ensidesktopapp.model.Eleve;

import java.sql.SQLException;
import java.util.List;

public interface IEleveDAO {
    void insert(Eleve student) throws SQLException;
    void update(Eleve student) throws SQLException;
    List<Eleve> getAll() throws SQLException;
    Eleve findById(int id) throws SQLException;
    void delete(int id) throws SQLException;
}
