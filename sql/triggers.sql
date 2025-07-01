CREATE OR REPLACE FUNCTION passer_niveau()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.moyenne >= 10 THEN
        UPDATE Eleve
        SET niveau = niveau + 1
        WHERE id = NEW.code_eleve;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_passer_niveau
    AFTER INSERT ON Moyennes
    FOR EACH ROW
EXECUTE FUNCTION passer_niveau();
