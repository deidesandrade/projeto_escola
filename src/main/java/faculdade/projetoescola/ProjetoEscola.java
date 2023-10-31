
package faculdade.projetoescola;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjetoEscola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de alunos!");

        while (true) {
            System.out.println("Escolha uma operação: ");
            System.out.println("1. Inserir aluno");
            System.out.println("2. Deletar aluno");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                // Solicitar dados para inserir um novo aluno
                System.out.print("Matrícula: ");
                String matricula = scanner.next();
                System.out.print("Nome: ");
                String nome = scanner.next();
                System.out.print("Ano: ");
                int ano = scanner.nextInt();

                try {
                    Connection connection = DatabaseConnection.connect();
                    Aluno novoAluno = new Aluno(matricula, nome, ano);
                    AlunoUpdate.inserirAluno(connection, novoAluno);
                    System.out.println("Novo aluno inserido com sucesso.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (escolha == 2) {
                // Solicitar dados para deletar um aluno
                System.out.print("Nome do aluno a ser excluído: ");
                String nomeAluno = scanner.next();

                try {
                    Connection connection = DatabaseConnection.connect();
                    AlunoUpdate.deleteAluno(connection, nomeAluno);
                    System.out.println("Aluno excluído com sucesso.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (escolha == 3) {
                break; // Sair do programa
            } else {
                System.out.println("Escolha inválida. Por favor, escolha uma operação válida.");
            }
        }

        System.out.println("Encerrando o programa. Obrigado!");
    }
}
