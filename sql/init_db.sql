CREATE TABLE IF NOT EXISTS Filiere (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Module (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL,
    niveau INTEGER NOT NULL,
    semestre INTEGER NOT NULL,
    code_filiere INTEGER REFERENCES Filiere(id)
);

CREATE TABLE IF NOT EXISTS Matiere (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    designation VARCHAR(100) NOT NULL,
    volume_horaire INTEGER NOT NULL,
    code_module INTEGER REFERENCES Module(id)
);

CREATE TABLE IF NOT EXISTS Eleve (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    niveau INTEGER NOT NULL,
    code_filiere INTEGER REFERENCES Filiere(id)
);

CREATE TABLE IF NOT EXISTS Notes (
    id SERIAL PRIMARY KEY,
    code_eleve INTEGER REFERENCES Eleve(id),
    code_matiere INTEGER REFERENCES Matiere(id),
    note NUMERIC(4,2) CHECK (note >= 0 AND note <= 20)
);

CREATE TABLE IF NOT EXISTS Moyennes (
    id SERIAL PRIMARY KEY,
    code_eleve INTEGER REFERENCES Eleve(id),
    code_filiere INTEGER REFERENCES Filiere(id),
    niveau INTEGER NOT NULL,
    moyenne NUMERIC(4,2)
);

CREATE TABLE IF NOT EXISTS Users (
    id    SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    password TEXT NOT NULL
);

INSERT INTO Users (email, nom, prenom, password)
VALUES ('benhdouba.ziyad@gmail.com', 'Benhdouba', 'Ziyad', '');
