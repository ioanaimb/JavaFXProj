package sample.model;

public class Student {
    private String nume, prenume, materia;
    private int varsta;

    public Student(String nume, String prenume, int varsta, String materia) {
        this.nume = nume;
        this.prenume = prenume;
        this.materia = materia;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getMateria() {
        return materia;
    }

    public int getVarsta() {
        return varsta;
    }
}
