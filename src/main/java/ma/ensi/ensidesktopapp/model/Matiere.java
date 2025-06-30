// Fichier : Matiere.java
package ma.ensi.ensidesktopapp.model;

public class Matiere {
    private int id;
    private String code;
    private String designation;
    private int volumeHoraire;
    private String codeModule;

    public Matiere(int id, String code, String designation, int volumeHoraire, String codeModule) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.volumeHoraire = volumeHoraire;
        this.codeModule = codeModule;
    }

    public Matiere(String code, String designation, int volumeHoraire, String codeModule) {
        this(0, code, designation, volumeHoraire, codeModule);
        // TODO fix id
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getDesignation() { return designation; }
    public int getVolumeHoraire() { return volumeHoraire; }
    public String getCodeModule() { return codeModule; }

    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setVolumeHoraire(int volumeHoraire) { this.volumeHoraire = volumeHoraire; }
    public void setCodeModule(String codeModule) { this.codeModule = codeModule; }
}
