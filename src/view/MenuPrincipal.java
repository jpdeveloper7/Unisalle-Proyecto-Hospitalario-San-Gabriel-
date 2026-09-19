package view;

import java.sql.SQLException;

import model.Doctor;
import model.Enfermera;
import model.Paciente;
import util.EntradaConsola;
import repository.PacienteRepositorio;
import repository.EnfermeraRepositorio;
import repository.DoctorRepositorio;

public class MenuPrincipal {
    
    private final PacienteRepositorio pacientes = new PacienteRepositorio();
    private final EnfermeraRepositorio enfermeras = new EnfermeraRepositorio();
    private final DoctorRepositorio medicos = new DoctorRepositorio();

public void iniciar() {
    int opcion;

    do {
        System.out.println("=== Hospital San Gabriel ===");
        System.out.println("1. registrar paciente");
        System.out.println("2. registrar enfermera");
        System.out.println("3. registrar doctor");
        System.out.println("4. listar pacientes");
        System.out.println("6. listar doctores");
        System.out.println("7. crear cita");
        System.out.println("8. ver citas");
        System.out.println("9. cancelar cita");
        System.out.println("5. Salir");
        opcion = EntradaConsola.leerEntero("Seleccione una opción: ");
        System.out.println();
    
        try {
            switch(opcion){
                case 1 -> registrarPaciente();
                case 2 -> registrarEnfermera();
                case 3 -> registrarDoctor();
                case 4 -> listarPacientes();
                case 5 -> System.out.println("Saliendo del programa...");
                case 6 -> listarDoctores();
                case 7 -> crearCita();
                case 8 -> verCitas();
                case 9 -> cancelarCita();
                default -> System.out.println("Opción inválida. Por favor, seleccione una opción válida.");


            }
        }
        catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
        System.out.println();

    } while (opcion != 5);
}


public void registrarPaciente() throws SQLException {
    String nombres = EntradaConsola.leerTexto("Ingrese el nombre del paciente: ");
    int edad = EntradaConsola.leerEntero("Ingrese la edad del paciente: ");
    String documento = EntradaConsola.leerTexto("Ingrese el documento del paciente: ");
   int id = pacientes.siguienteid();
   pacientes.guardar(new Paciente(id, nombres, edad, documento));
   System.out.println("paciente registrado exitosamente con ID: " + id);


}

public void registrarEnfermera() throws SQLException {
    String nombres = EntradaConsola.leerTexto("Ingrese el nombre de la enfermera: ");
    int edad = EntradaConsola.leerEntero("Ingrese la edad de la enfermera: ");
    String documento = EntradaConsola.leerTexto("Ingrese el documento de la enfermera: ");
    int id = enfermeras.siguienteid();
    enfermeras.guardar(new Enfermera(id, nombres, edad, documento));
    System.out.println("Enfermera registrada exitosamente con ID: " + id);
}

public void registrarDoctor() throws SQLException {
    String nombre = EntradaConsola.leerTexto("Ingrese el nombre del doctor: ");
    int edad = EntradaConsola.leerEntero("Ingrese la edad del doctor: ");
    String documento = EntradaConsola.leerTexto("Ingrese el documento del doctor: ");
    String especialidad = EntradaConsola.leerTexto("Ingrese la especialidad del doctor: ");
    int id = medicos.siguienteid();
    medicos.guardar(new Doctor(id, nombre, edad, documento, especialidad));
    System.out.println("Doctor registrado exitosamente con ID: " + id);
}

public void listarPacientes() {
    System.out.println("La consulta de pacientes aún no está implementada en PacienteRepositorio.");
}

public void listarDoctores() {
    System.out.println("La consulta de doctores aún no está implementada en DoctorRepositorio.");
}

public void crearCita() {
    System.out.println("La gestión de citas aún no está implementada en CitaRepositorio.");
}

public void verCitas() {
    System.out.println("La gestión de citas aún no está implementada en CitaRepositorio.");
}

public void cancelarCita() {
    System.out.println("La gestión de citas aún no está implementada en CitaRepositorio.");
}

}



