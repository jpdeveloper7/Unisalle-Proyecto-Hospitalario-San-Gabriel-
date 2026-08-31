package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import model.Enfermera;

public class EnfermeraRepositorio {

    public int siguienteid() throws SQLException {
        return maxId() + 1;
    }

    public void guardar(Enfermera e) throws SQLException {
        if (e == null) {
            return;
        }

        String sql = "INSERT INTO enfermeras (id, nombres, edad, documento) VALUES (?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE nombres = VALUES(nombres), edad = VALUES(edad), documento = VALUES(documento)";

        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getNombres());
            ps.setInt(3, e.getEdad());
            ps.setString(4, e.getDocumento());

            ps.executeUpdate();
        }
    }

    public Enfermera buscarPorId(int id) throws SQLException {
        try (Connection c = ConexionBD.obtenerConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, nombres, edad, documento FROM enfermeras WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Enfermera e = new Enfermera();
                    e.setId(rs.getInt("id"));
                    e.setNombres(rs.getString("nombres"));
                    e.setEdad(rs.getInt("edad"));
                    e.setDocumento(rs.getString("documento"));
                    return e;
                }
                return null;
            }
        }
    }

    private int maxId() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM enfermeras";
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
