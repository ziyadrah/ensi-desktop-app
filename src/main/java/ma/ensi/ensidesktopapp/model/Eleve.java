package ma.ensi.ensidesktopapp.model;

public class Eleve {
    private int id;
    private String code;
    private String nom;
    private String prenom;
    private String niveau;
    private String codeFiliere;

    public Eleve(int id, String code, String nom, String prenom, String niveau, String codeFiliere) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.codeFiliere = codeFiliere;
    }

    public Eleve(String code, String nom, String prenom, String niveau, String codeFiliere) {
        this(0, code, nom, prenom, niveau, codeFiliere);
        // TODO fix id
    }

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
    public String getCodeFiliere() { return codeFiliere; }
    public void setCodeFiliere(String codeFiliere) { this.codeFiliere = codeFiliere; }
}
