package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

/*Comentários!!!*/
/* HashMap carregar dados e recuperar através de um valor */

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Informe o Login: ");
		String senha = JOptionPane.showInputDialog("Informe a Senha: ");

		if (login.equalsIgnoreCase("admin") && senha.equals("admin")) {

			List<Aluno> alunos = new ArrayList<Aluno>();
			/* é uma lista que dentro dela temos uma chave que identifica uma sequencia de valores também */
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			for (int qte = 1; qte <= 5; qte++) {

				String nome = (JOptionPane.showInputDialog("Nome: " + qte + " ?"));
				/*
				 * aluno.setIdade(Integer.valueOf( JOptionPane.showInputDialog("Idade:")));
				 * aluno.setDataNascimento( JOptionPane.showInputDialog("Nascimento: "));
				 * aluno.setCPF(JOptionPane.showInputDialog("CPF:")); aluno.setNomeMae(
				 * JOptionPane.showInputDialog("Mãe: ")); aluno.setNomePai(
				 * JOptionPane.showInputDialog("Pai ")); aluno.setDataMatricula(JOptionPane
				 * .showInputDialog("Data Matrícula: ")); aluno.setNomeEscola(JOptionPane
				 * .showInputDialog("Escola / Faculdade")); aluno.setSerieMatriculado(
				 * JOptionPane.showInputDialog("Semestre: "));
				 */

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);

				for (int pos = 1; pos <= 1; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Disciplina " + pos + "?");
					String notaDisciplina = JOptionPane.showInputDialog("Nota " + pos + "?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);
				}

				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

				if (escolha == 0) {

					int continuarRemover = 0;
					int posicao = 1;
					while (continuarRemover == 0) {

						String removeDisciplina = JOptionPane.showInputDialog("Qual disciplina? (1,2,3 ou 4)");
						aluno1.getDisciplinas().remove(Integer.valueOf(removeDisciplina).intValue() - posicao);
						posicao++;

						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover? ");
					}

				}
				alunos.add(aluno1);
			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) { /* Separado em listas */
				if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}

			/* Processamento das listas */

			System.out.println("-------------------- Lista dos Aprovados --------------------");

			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Resultado: " + aluno.getAlunoAprovado());
				System.out.println("Média: " + aluno.getMediaAluno());
			}

			System.out.println("-------------------- Fim dos Aprovados --------------------\n");

			System.out.println("-------------------- Lista da Recuperação --------------------");

			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Resultado: " + aluno.getAlunoAprovado());
				System.out.println("Média: " + aluno.getMediaAluno());
			}

			System.out.println("-------------------- Fim da Recuperação --------------------\n");

			System.out.println("-------------------- Lista dos Reprovados --------------------");

			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Resultado: " + aluno.getAlunoAprovado());
				System.out.println("Média: " + aluno.getMediaAluno());
			}

			System.out.println("-------------------- Fim dos Reprovados --------------------");
		} else if (login.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login e senha");
		} else {
			JOptionPane.showMessageDialog(null, "Login ou senha incorreto!!");
		}
	}
}
