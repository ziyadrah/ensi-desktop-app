CREATE OR REPLACE PROCEDURE insert_eleve(
    p_code VARCHAR,
    p_nom VARCHAR,
    p_prenom VARCHAR,
    p_niveau INTEGER,
    p_code_filiere INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Eleve (code, nom, prenom, niveau, code_filiere)
    VALUES (p_code, p_nom, p_prenom, p_niveau, p_code_filiere);
END;
$$;

CREATE OR REPLACE PROCEDURE update_eleve(
    p_id INTEGER,
    p_code VARCHAR,
    p_nom VARCHAR,
    p_prenom VARCHAR,
    p_niveau INTEGER,
    p_code_filiere INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Eleve
    SET code         = p_code,
        nom          = p_nom,
        prenom       = p_prenom,
        niveau       = p_niveau,
        code_filiere = p_code_filiere
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_eleve(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Eleve WHERE id = p_id;
END;
$$;

--

CREATE OR REPLACE PROCEDURE insert_filiere(
    p_code VARCHAR,
    p_designation VARCHAR
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Filiere(code, designation)
    VALUES (p_code, p_designation);
END;
$$;

CREATE OR REPLACE PROCEDURE update_filiere(
    p_id INTEGER,
    p_code VARCHAR,
    p_designation VARCHAR
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Filiere
    SET code = p_code, designation = p_designation
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_filiere(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Filiere
    WHERE id = p_id;
END;
$$;

--

CREATE OR REPLACE PROCEDURE insert_module(
    p_code VARCHAR,
    p_designation VARCHAR,
    p_niveau INTEGER,
    p_semestre INTEGER,
    p_code_filiere INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Module(
        code,
        designation,
        niveau,
        semestre,
        code_filiere
    )
    VALUES (
            p_code,
            p_designation,
            p_niveau,
            p_semestre,
            p_code_filiere
    );
END;
$$;

CREATE OR REPLACE PROCEDURE update_module(
    p_id INTEGER,
    p_code VARCHAR,
    p_designation VARCHAR,
    p_niveau INTEGER,
    p_semestre INTEGER,
    p_code_filiere INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Module
    SET code         = p_code,
        designation  = p_designation,
        niveau       = p_niveau,
        semestre     = p_semestre,
        code_filiere = p_code_filiere
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_module(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Module WHERE id = p_id;
END;
$$;

--

CREATE OR REPLACE PROCEDURE insert_matiere(
    p_code VARCHAR,
    p_designation VARCHAR,
    p_vh INTEGER,
    p_code_module INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Matiere(code, designation, volume_horaire, code_module)
    VALUES (p_code, p_designation, p_vh, p_code_module);
END;
$$;

CREATE OR REPLACE PROCEDURE update_matiere(
    p_id INTEGER,
    p_code VARCHAR,
    p_designation VARCHAR,
    p_vh INTEGER,
    p_code_module INTEGER
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Matiere
    SET code           = p_code,
        designation    = p_designation,
        volume_horaire = p_vh,
        code_module    = p_code_module
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_matiere(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Matiere
    WHERE id = p_id;
END;
$$;

--

CREATE OR REPLACE PROCEDURE insert_note(
    p_code_eleve INTEGER,
    p_code_matiere INTEGER,
    p_note NUMERIC
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Notes(code_eleve, code_matiere, note)
    VALUES (p_code_eleve, p_code_matiere, p_note);
END;
$$;

CREATE OR REPLACE PROCEDURE update_note(
    p_id INTEGER,
    p_code_eleve INTEGER,
    p_code_matiere INTEGER,
    p_note NUMERIC
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Notes
    SET code_eleve   = p_code_eleve,
        code_matiere = p_code_matiere,
        note         = p_note
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_note(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Notes WHERE id = p_id;
END;
$$;

--

CREATE OR REPLACE PROCEDURE insert_moyenne(
    p_code_eleve INTEGER,
    p_code_filiere INTEGER,
    p_niveau INTEGER,
    p_moyenne NUMERIC
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO Moyennes(code_eleve, code_filiere, niveau, moyenne)
    VALUES (p_code_eleve, p_code_filiere, p_niveau, p_moyenne);
END;
$$;

CREATE OR REPLACE PROCEDURE update_moyenne(
    p_id INTEGER,
    p_code_eleve INTEGER,
    p_code_filiere INTEGER,
    p_niveau INTEGER,
    p_moyenne NUMERIC
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE Moyennes
    SET code_eleve   = p_code_eleve,
        code_filiere = p_code_filiere,
        niveau       = p_niveau,
        moyenne      = p_moyenne
    WHERE id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_moyenne(p_id INTEGER)
    LANGUAGE plpgsql
AS
$$
BEGIN
    DELETE FROM Moyennes WHERE id = p_id;
END;
$$;
