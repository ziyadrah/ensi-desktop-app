// Fichier : StudentController.java
// (inchangé)
package ma.ensi.ensidesktopapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import ma.ensi.ensidesktopapp.model.Eleve;
import ma.ensi.ensidesktopapp.service.EleveService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveController {
    @FXML
    private TextField txtCode, txtNom, txtPrenom;
    @FXML private Spinner<Integer> spinnerNiveau;
    @FXML private ComboBox<String> comboFiliere;

    private final EleveService studentService = new EleveService();

    @FXML
    public void handleAddEleve() {
        try {
            Eleve s = new Eleve();
            s.setCode(txtCode.getText());
            s.setNom(txtNom.getText());
            s.setPrenom(txtPrenom.getText());
            s.setNiveau(spinnerNiveau.getValue());
            s.setCodeFiliere(1); // exemple simplifié

            studentService.addEleve(s);
            showInfo("Étudiant ajouté avec succès.");
        } catch (Exception e) {
            showError("Erreur : " + e.getMessage());
        }
    }

    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }
}
