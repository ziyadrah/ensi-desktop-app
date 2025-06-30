CREATE TABLE Filiere (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL
);

CREATE TABLE Module (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL,
    niveau INTEGER NOT NULL,
    semestre INTEGER NOT NULL,
    code_filiere INTEGER REFERENCES Filiere(id)
);

CREATE TABLE Matiere (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL,
    volume_horaire INTEGER NOT NULL,
    code_module INTEGER REFERENCES Module(id)
);

CREATE TABLE Eleve (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    niveau INTEGER NOT NULL,
    code_filiere INTEGER REFERENCES Filiere(id)
);

CREATE TABLE Notes (
    id SERIAL PRIMARY KEY,
    code_eleve INTEGER REFERENCES Eleve(id),
    code_matiere INTEGER REFERENCES Matiere(id),
    note NUMERIC(4,2) CHECK (note >= 0 AND note <= 20)
);

CREATE TABLE Moyennes (
    id SERIAL PRIMARY KEY,
    code_eleve INTEGER REFERENCES Eleve(id),
    code_filiere INTEGER REFERENCES Filiere(id),
    niveau INTEGER NOT NULL,
    moyenne NUMERIC(4,2)
);
