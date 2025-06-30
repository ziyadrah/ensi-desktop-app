// Fichier : Moyenne.java
package ma.ensi.ensidesktopapp.model;

public class Moyenne {
    private int id;
    private String codeEleve;
    private String codeFiliere;
    private String niveau;
    private double moyenne;

    public Moyenne(int id, String codeEleve, String codeFiliere, String niveau, double moyenne) {
        this.id = id;
        this.codeEleve = codeEleve;
        this.codeFiliere = codeFiliere;
        this.niveau = niveau;
        this.moyenne = moyenne;
    }

    public Moyenne(String codeEleve, String codeFiliere, String niveau, double moyenne) {
        this(0, codeEleve, codeFiliere, niveau, moyenne);
        // TODO fix id
    }

    public int getId() { return id; }
    public String getCodeEleve() { return codeEleve; }
    public String getCodeFiliere() { return codeFiliere; }
    public String getNiveau() { return niveau; }
    public double getMoyenne() { return moyenne; }

    public void setId(int id) { this.id = id; }
    public void setCodeEleve(String codeEleve) { this.codeEleve = codeEleve; }
    public void setCodeFiliere(String codeFiliere) { this.codeFiliere = codeFiliere; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
    public void setMoyenne(double moyenne) { this.moyenne = moyenne; }
}
