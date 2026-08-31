package model;

public class Doctor {

    private int id;
    private String nombre;
    private int edad;
    private String documento;
    private String especialidad;

    public Doctor() {
    }

    public Doctor(int id, String nombre, int edad, String documento, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrarInformacion() {
        System.out.println("[id: " + id + "] Doctor: " + nombre + ", Especialidad: " + especialidad + ", Edad: " + edad + ", Documento: " + documento);
    }
}
