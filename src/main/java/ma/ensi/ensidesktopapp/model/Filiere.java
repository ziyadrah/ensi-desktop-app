// Fichier : Filiere.java
package ma.ensi.ensidesktopapp.model;

public class Filiere {
    private int id;
    private String code;
    private String designation;

    public Filiere(int id, String code, String designation) {
        this.id = id;
        this.code = code;
        this.designation = designation;
    }

    public Filiere(String code, String designation) {
        this(0, code, designation);
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getDesignation() { return designation; }
    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDesignation(String designation) { this.designation = designation; }
}
