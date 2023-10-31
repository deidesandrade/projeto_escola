
package faculdade.projetoescola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoUpdate {
    public static void inserirAluno(Connection connection, Aluno aluno) throws SQLException {
        try (connection) {
            String sql = "INSERT INTO ALUNO (MATRICULA, NOME, ENTRADA) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.matricula);
            ps.setString(2, aluno.nome);
            ps.setInt(3, aluno.ano);
            ps.executeUpdate();
        }
    }

    public static void deleteAluno(Connection connection, String matricula) throws SQLException {
        try (connection) {
            String sql = "DELETE FROM ALUNO WHERE MATRICULA = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, matricula);
            ps.executeUpdate();
        }
    }
}
