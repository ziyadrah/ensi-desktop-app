package ma.ensi.ensidesktopapp.model;

public class Eleve {
    private int id;
    private String code;
    private String nom;
    private String prenom;
    private String niveau;
    private String codeFil;

    public Eleve(int id, String code, String nom, String prenom, String niveau, String codeFil) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.codeFil = codeFil;
    }

    public Eleve(String code, String nom, String prenom, String niveau, String codeFil) {
        this(0, code, nom, prenom, niveau, codeFil);
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
    public String getCodeFil() { return codeFil; }
    public void setCodeFil(String codeFil) { this.codeFil = codeFil; }
}
