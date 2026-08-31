package model;

public class Enfermera {

    private int id;
    private String nombres;
    private int edad;
    private String documento;

    public Enfermera() {
    }

    public Enfermera(int id, String nombres, int edad, String documento) {
        this.id = id;
        this.nombres = nombres;
        this.edad = edad;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void mostrarInformacion() {
        System.out.println("[id: " + id + "] Enfermera: " + nombres + ", Edad: " + edad + ", Documento: " + documento);
    }
}
