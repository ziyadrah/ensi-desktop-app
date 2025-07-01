// Fichier : StudentController.java
// (inchangé)
package ma.ensi.ensidesktopapp.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import ma.ensi.ensidesktopapp.model.Eleve;
import ma.ensi.ensidesktopapp.service.EleveService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveController {
    @FXML private TextField txtCode, txtNom, txtPrenom;
    @FXML private Spinner<Integer> spinnerNiveau;
    @FXML private ComboBox<String> comboFiliere;

    private final EleveService studentService = new EleveService();
    private Eleve selectedStudent = null;

    @FXML
    private void handleAddEleve() {
        try {
            String code = txtCode.getText().trim();
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            int niveau = spinnerNiveau.getValue();
            int codeFiliere = Integer.parseInt(comboFiliere.getValue());

            if (code.isEmpty() || nom.isEmpty() || prenom.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Champs obligatoires manquants.");
                return;
            }

            if (selectedStudent == null) {
                Eleve newEleve = new Eleve(0, code, nom, prenom, niveau, codeFiliere);
                studentService.addEleve(newEleve);
                showAlert(Alert.AlertType.INFORMATION, "Étudiant ajouté avec succès.");
            } else {
                selectedStudent.setCode(code);
                selectedStudent.setNom(nom);
                selectedStudent.setPrenom(prenom);
                selectedStudent.setNiveau(niveau);
                selectedStudent.setCodeFiliere(codeFiliere);
                studentService.updateStudent(selectedStudent);
                showAlert(Alert.AlertType.INFORMATION, "Étudiant modifié avec succès.");
            }

            resetForm();
            loadElevesToTable();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur : " + e.getMessage());
        }
    }

    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }

    @FXML private VBox sidebar;
    @FXML private Button deleteButton, addEditButton, toggleSidebarBtn;
    @FXML private TableView<Eleve> tableStudents;
    @FXML private TableColumn<Eleve, String> colCode, colNom, colPrenom;
    @FXML private TableColumn<Eleve, Integer> colId, colNiveau, colFiliere;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colNiveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        colFiliere.setCellValueFactory(new PropertyValueFactory<>("codeFiliere"));

        spinnerNiveau.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));

        tableStudents.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                selectedStudent = newSel;
                txtCode.setText(newSel.getCode());
                txtNom.setText(newSel.getNom());
                txtPrenom.setText(newSel.getPrenom());
                spinnerNiveau.getValueFactory().setValue(newSel.getNiveau());
                comboFiliere.setValue(String.valueOf(newSel.getCodeFiliere()));
                addEditButton.setText("Modifier");
            }
        });

        loadElevesToTable();
    }

    private void loadElevesToTable() {
        try {
            List<Eleve> students = studentService.getAllEleves();
            tableStudents.setItems(FXCollections.observableArrayList(students));
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de chargement : " + e.getMessage());
        }
    }

    private void resetForm() {
        txtCode.clear();
        txtNom.clear();
        txtPrenom.clear();
        spinnerNiveau.getValueFactory().setValue(1);
        comboFiliere.getSelectionModel().clearSelection();
        selectedStudent = null;
        addEditButton.setText("Ajouter");
    }

    @FXML
    private void toggleSidebar() {
        boolean isVisible = sidebar.isVisible();
        sidebar.setVisible(!isVisible);
        sidebar.setManaged(!isVisible);
        toggleSidebarBtn.setText(isVisible ? "⏵" : "⏴");
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setContentText(msg);
        alert.show();
    }

    @FXML
    private void handleUpdateStudent() {
        if (selectedStudent == null) {
            showAlert(Alert.AlertType.WARNING, "Aucun étudiant sélectionné pour la modification.");
            return;
        }

        try {
            selectedStudent.setCode(txtCode.getText().trim());
            selectedStudent.setNom(txtNom.getText().trim());
            selectedStudent.setPrenom(txtPrenom.getText().trim());
            selectedStudent.setNiveau(spinnerNiveau.getValue());
            selectedStudent.setCodeFiliere(Integer.parseInt(comboFiliere.getValue()));

            studentService.updateStudent(selectedStudent);
            showAlert(Alert.AlertType.INFORMATION, "Étudiant modifié avec succès.");
            loadElevesToTable();
            resetForm();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de modification : " + e.getMessage());
        }
    }

    @FXML
    private void handleDeleteStudent() {
        Eleve student = tableStudents.getSelectionModel().getSelectedItem();
        if (student == null) {
            showAlert(Alert.AlertType.WARNING, "Aucun étudiant sélectionné pour la suppression.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmer la suppression");
        confirm.setContentText("Voulez-vous vraiment supprimer cet étudiant ?");
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    studentService.deleteEleve(student.getId());
                    loadElevesToTable();
                    resetForm();
                    showAlert(Alert.AlertType.INFORMATION, "Étudiant supprimé.");
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Erreur de suppression : " + e.getMessage());
                }
            }
        });
    }

}
