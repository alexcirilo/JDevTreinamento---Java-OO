package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;

/*Coment�rios!!!*/
/* HashMap carregar dados e recuperar atrav�s de um valor */

public class PrimeiraClasseJava {
	public static void main(String[] args) {

		try {

			lerArquivo();

			String login = JOptionPane
					.showInputDialog("Informe o Login: ");
			String senha = JOptionPane
					.showInputDialog("Informe a Senha: ");

			if (new FuncaoAutenticacao(
					new Diretor(login, senha))
							.autenticar()) { /*
												 * Ir� bloquear o contrato para autorizar somente quem realmente tem o contrato
												 * 100% leg�timo
												 */

				List<Aluno> alunos = new ArrayList<Aluno>();
				// new ArrayList<Aluno>();
				/*
				 * � uma lista que dentro dela temos uma chave que identifica uma sequencia de
				 * valores tamb�m
				 */
				HashMap<String, List<Aluno>> maps =
						new HashMap<String, List<Aluno>>();

				for (int qte = 1; qte <= 1; qte++) {

					String nome =
							(JOptionPane.showInputDialog(
									"Nome: " + qte + " ?"));
					Aluno aluno1 = new Aluno();
					aluno1.setNome(nome);

					aluno1.setIdade(Integer.valueOf(
							JOptionPane.showInputDialog(
									"Idade:")));
					/*
					 * aluno.setDataNascimento( JOptionPane.showInputDialog("Nascimento: "));
					 * aluno.setCPF(JOptionPane.showInputDialog("CPF:")); aluno.setNomeMae(
					 * JOptionPane.showInputDialog("M�e: ")); aluno.setNomePai(
					 * JOptionPane.showInputDialog("Pai ")); aluno.setDataMatricula(JOptionPane
					 * .showInputDialog("Data Matr�cula: ")); aluno.setNomeEscola(JOptionPane
					 * .showInputDialog("Escola / Faculdade")); aluno.setSerieMatriculado(
					 * JOptionPane.showInputDialog("Semestre: "));
					 */

					for (int pos = 1; pos <= 1; pos++) {
						String nomeDisciplina =
								JOptionPane.showInputDialog(
										"Disciplina " + pos
												+ "?");
						String notaDisciplina = JOptionPane
								.showInputDialog("Nota "
										+ pos + "?");

						Disciplina disciplina =
								new Disciplina();
						disciplina.setDisciplina(
								nomeDisciplina);
						disciplina.setNota(Double
								.valueOf(notaDisciplina));

						aluno1.getDisciplinas()
								.add(disciplina);
					}

					int escolha = JOptionPane
							.showConfirmDialog(null,
									"Deseja remover alguma disciplina?");

					if (escolha == 0) {

						int continuarRemover = 0;
						int posicao = 1;
						while (continuarRemover == 0) {

							String removeDisciplina =
									JOptionPane
											.showInputDialog(
													"Qual disciplina? (1,2,3 ou 4)");
							aluno1.getDisciplinas()
									.remove(Integer.valueOf(
											removeDisciplina)
											.intValue()
											- posicao);
							posicao++;

							continuarRemover = JOptionPane
									.showConfirmDialog(null,
											"Continuar a remover? ");
						}

					}
					alunos.add(aluno1);
				}

				maps.put(StatusAluno.APROVADO,
						new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO,
						new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO,
						new ArrayList<Aluno>());

				for (Aluno aluno : alunos) { /* Separado em listas */
					if (aluno.getAlunoAprovado()
							.equalsIgnoreCase(
									StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO)
								.add(aluno);
					} else if (aluno.getAlunoAprovado()
							.equalsIgnoreCase(
									StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO)
								.add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO)
								.add(aluno);
					}
				}

				/* Processamento das listas */

				System.out.println(
						"-------------------- Lista dos Aprovados --------------------");

				for (Aluno aluno : maps
						.get(StatusAluno.APROVADO)) {
					System.out.println(
							"Nome: " + aluno.getNome());
					System.out.println("Resultado: "
							+ aluno.getAlunoAprovado());
					System.out.println("M�dia: "
							+ aluno.getMediaAluno());
				}

				System.out.println(
						"-------------------- Fim dos Aprovados --------------------\n");

				System.out.println(
						"-------------------- Lista da Recupera��o --------------------");

				for (Aluno aluno : maps
						.get(StatusAluno.RECUPERACAO)) {
					System.out.println(
							"Nome: " + aluno.getNome());
					System.out.println("Resultado: "
							+ aluno.getAlunoAprovado());
					System.out.println("M�dia: "
							+ aluno.getMediaAluno());
				}

				System.out.println(
						"-------------------- Fim da Recupera��o --------------------\n");

				System.out.println(
						"-------------------- Lista dos Reprovados --------------------");

				for (Aluno aluno : maps
						.get(StatusAluno.REPROVADO)) {
					System.out.println(
							"Nome: " + aluno.getNome());
					System.out.println("Resultado: "
							+ aluno.getAlunoAprovado());
					System.out.println("M�dia: "
							+ aluno.getMediaAluno());
				}

				System.out.println(
						"-------------------- Fim dos Reprovados --------------------");
			} else if (login.isEmpty() || senha.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Preencha o login e senha");
			} else {
				JOptionPane.showMessageDialog(null,
						"Login ou senha incorreto!!");
			}
		} catch (Exception e) {
			StringBuilder saida = new StringBuilder();
			e.printStackTrace();

			for (int pos = 0;
					pos < e.getStackTrace().length; pos++) {
				saida.append("\nClasse de erro: "
						+ e.getStackTrace()[pos]
								.getClassName());
				saida.append("\nM�todo de erro: "
						+ e.getStackTrace()[pos]
								.getMethodName());
				saida.append("\nLinha de erro: "
						+ e.getStackTrace()[pos]
								.getLineNumber());
				saida.append("\nClass: "
						+ e.getClass().getName());
			}

			JOptionPane.showMessageDialog(null,
					"Erro ao processar notas "
							+ saida.toString());
		} finally { /* sempre � executado ocorrendo erros ou n�o */

			/*
			 * finally sempre � usado quando se precisa executar um processo acontecendo um
			 * erro ou n�o
			 */
			JOptionPane.showMessageDialog(null,
					"Aprendendo Java!");
		}
	}

	public static void lerArquivo()
			throws FileNotFoundException {

		File fil = new File("c://lines.txt");
		Scanner scanner = new Scanner(fil);

	}
}
