package ma.ensi.ensidesktopapp.model;

public class Module {
    private int id;
    private String code;
    private String designation;
    private String niveau;
    private int semestre;
    private String codeFil;

    public Module(int id, String code, String designation, String niveau, int semestre, String codeFil) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.niveau = niveau;
        this.semestre = semestre;
        this.codeFil = codeFil;
    }

    public Module(String code, String designation, String niveau, int semestre, String codeFil) {
        this(0, code, designation, niveau, semestre, codeFil);
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getDesignation() { return designation; }
    public String getNiveau() { return niveau; }
    public int getSemestre() { return semestre; }
    public String getCodeFil() { return codeFil; }

    public void setId(int id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setCodeFil(String codeFil) { this.codeFil = codeFil; }
}
