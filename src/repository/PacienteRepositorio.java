package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import model.Paciente;

public class PacienteRepositorio {

    public int siguienteid() throws SQLException {
        return maxId() + 1;
    }

    public void guardar(Paciente p) throws SQLException {
        if (p == null) {
            return;
        }

        String sql = "INSERT INTO pacientes (id, nombres, edad, documento) VALUES (?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE nombres = VALUES(nombres), edad = VALUES(edad), documento = VALUES(documento)";

        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombres());
            ps.setInt(3, p.getEdad());
            ps.setString(4, p.getDocumento());

            ps.executeUpdate();
        }
    }

    public Paciente buscarPorId(int id) throws SQLException {
        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, nombres, edad, documento FROM pacientes WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Paciente p = new Paciente();
                    p.setId(rs.getInt("id"));
                    p.setNombres(rs.getString("nombres"));
                    p.setEdad(rs.getInt("edad"));
                    p.setDocumento(rs.getString("documento"));
                    return p;
                }
                return null;
            }
        }
    }

    private int maxId() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM pacientes";
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
