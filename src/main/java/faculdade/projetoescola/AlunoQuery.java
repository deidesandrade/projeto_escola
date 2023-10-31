
package faculdade.projetoescola;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoQuery {
    public static List<Aluno> getAllAlunos(Connection connection) throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        try (connection) {
            Statement st = connection.createStatement();
            ResultSet r1 = st.executeQuery("SELECT * FROM ALUNO");
            while (r1.next()) {
                lista.add(new Aluno(
                    r1.getString("MATRICULA"),
                    r1.getString("NOME"),
                    r1.getInt("ENTRADA")
                ));
            }
        }
        return lista;
    }
}
