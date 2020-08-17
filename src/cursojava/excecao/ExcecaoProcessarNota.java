package cursojava.excecao;

public class ExcecaoProcessarNota extends Exception {
	public ExcecaoProcessarNota(String erro) {
		super("Vish, um erro no processamento das notas do aluno!\n" +erro);
	}
}
