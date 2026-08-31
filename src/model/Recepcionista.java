package model;

public class Recepcionista {

    int id;
    String nombres;
    int edad;
    String documento;

    public Recepcionista(int id, String nombres, int edad, String documento) {
        this.id = id;
        this.nombres = nombres;
        this.edad = edad;
        this.documento = documento;
    }

public void mostrarInformacion() {
        System.out.println("-----------------------");
        System.out.println("DATOS DEL RECEPCIONISTA");
        System.out.println( "-----------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombres: " + nombres);
        System.out.println("Edad: " + edad);
        System.out.println("Documento: " + documento);
    }
 

}
