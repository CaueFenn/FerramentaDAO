package dao;

import model.Ferramenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FerramentaDAOimpl implements FerramentaDAO {
    private String url;

    public FerramentaDAOimpl(String url) {
        this.url = url;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void salvarFerramenta(Ferramenta ferramenta) {
        String sql = "INSERT INTO ferramentas(nome, marca, custo) VALUES(?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ferramenta.getNome());
            pstmt.setString(2, ferramenta.getMarca());
            pstmt.setDouble(3, ferramenta.getCusto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizarFerramenta(Ferramenta ferramenta) {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ferramenta.getNome());
            pstmt.setString(2, ferramenta.getMarca());
            pstmt.setDouble(3, ferramenta.getCusto());
            pstmt.setInt(4, ferramenta.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void excluirFerramenta(int id) {
        String sql = "DELETE FROM ferramentas WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Ferramenta buscarFerramentaPorId(int id) {
        String sql = "SELECT * FROM ferramentas WHERE id = ?";
        Ferramenta ferramenta = null;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ferramenta = new Ferramenta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("custo")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ferramenta;
    }

    @Override
    public List<Ferramenta> listarTodasFerramentas() {
        String sql = "SELECT * FROM ferramentas";
        List<Ferramenta> ferramentas = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("custo")
                );
                ferramentas.add(ferramenta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ferramentas;
    }
}
