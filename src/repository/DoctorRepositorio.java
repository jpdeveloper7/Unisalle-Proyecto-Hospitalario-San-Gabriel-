package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import model.Doctor;

public class DoctorRepositorio {

    public int siguienteid() throws SQLException {
        return maxId() + 1;
    }

    public void guardar(Doctor d) throws SQLException {
        if (d == null) {
            return;
        }

        String sql = "INSERT INTO doctores (id, nombre, edad, documento, especialidad) VALUES (?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE nombre = VALUES(nombre), edad = VALUES(edad), documento = VALUES(documento), especialidad = VALUES(especialidad)";

        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, d.getId());
            ps.setString(2, d.getNombre());
            ps.setInt(3, d.getEdad());
            ps.setString(4, d.getDocumento());
            ps.setString(5, d.getEspecialidad());

            ps.executeUpdate();
        }
    }

    public Doctor buscarPorId(int id) throws SQLException {
        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, nombre, edad, documento, especialidad FROM doctores WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Doctor d = new Doctor();
                    d.setId(rs.getInt("id"));
                    d.setNombre(rs.getString("nombre"));
                    d.setEdad(rs.getInt("edad"));
                    d.setDocumento(rs.getString("documento"));
                    d.setEspecialidad(rs.getString("especialidad"));
                    return d;
                }
                return null;
            }
        }
    }

    private int maxId() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM doctores";
        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_id");
            }
            return 0;
        }
    }
}