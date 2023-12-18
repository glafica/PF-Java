package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conta;
import util.Conexiondb;

public class Contactodao {
    public void agregarConta(Conta conta) {
        String sql = "INSERT INTO contacto (nombre, mail, tema, fecha_alta) VALUES (?, ?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = Conexiondb.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, conta.getNombre());
            pstmt.setString(2, conta.getMail());
            pstmt.setString(3, conta.getTema());
            pstmt.setDate(4, conta.getFechaAlta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Conta obtenerPorId(int id) {
        String sql = "SELECT * FROM contacto WHERE id_orador = ?";
        try (Connection conn = Conexiondb.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Conta conta = new Conta();
                conta.setIdOrador(rs.getInt("id_orador"));
                conta.setNombre(rs.getString("nombre"));
                conta.setMail(rs.getString("mail"));
                conta.setTema(rs.getString("tema"));
                conta.setFechaAlta(rs.getDate("fecha_alta"));
                return conta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Conta> obtenerTodos() {
        List<Conta> contacto = new ArrayList<>();
        String sql = "SELECT * FROM contacto";
        try (Connection conn = Conexiondb.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setIdOrador(rs.getInt("id_orador"));
                conta.setNombre(rs.getString("nombre"));
                conta.setMail(rs.getString("mail"));
                conta.setTema(rs.getString("tema"));
                conta.setFechaAlta(rs.getDate("fecha_alta"));
                contacto.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacto;
    }

    public void actualizarConta(Conta conta) {
        String sql = "UPDATE contacto SET nombre = ?, mail = ?, tema = ?, fecha_alta = ? WHERE id_orador = ?";
        try (Connection conn = Conexiondb.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, conta.getNombre());
            pstmt.setString(2, conta.getMail());
            pstmt.setString(3, conta.getTema());
            pstmt.setDate(4, conta.getFechaAlta());
            pstmt.setInt(5, conta.getIdOrador());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarConta(int id) {
        String sql = "DELETE FROM contacto WHERE id_orador = ?";
        try (Connection conn = Conexiondb.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

