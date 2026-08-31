package model;

public class Cita {
    
    int id;
    int pacienteId;
    String pacienteNombres;
    int doctorId;
    String doctorNombres;
    String doctorEspecialidad;
    String fecha;
    String hora;
    String estado;
    
    public Cita(int id, int pacienteId, String pacienteNombres, int doctorId, String doctorNombres,
            String doctorEspecialidad, String fecha, String hora, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.pacienteNombres = pacienteNombres;
        this.doctorId = doctorId;
        this.doctorNombres = doctorNombres;
        this.doctorEspecialidad = doctorEspecialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }



    public void mostrarInformacion() {
       System.out.println( "[id: " + id + "] Cita: Paciente: " + pacienteNombres + ", Doctor: " + doctorNombres + ", Especialidad: " + doctorEspecialidad + ", Fecha: " + fecha + ", Hora: " + hora + ", Estado: " + estado);
    }

    
}
