package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setIdade(16);
		aluno.setNome("Alex Cirilo");
		aluno.setNomeEscola("JDev Treinamento");
		
		Diretor diretor = new Diretor();
		diretor.setIdade(46);
		diretor.setNome("Carlos");
		diretor.setTitulacao("Diretor");
		
		Secretario secretario = new Secretario();
		secretario.setIdade(18);
		secretario.setNome("Alex");
		secretario.setExperiencia("Media");
		secretario.setCPF("01706938217");
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
		System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.mensagemMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());
		
		System.out.println("Salário Aluno é: "+aluno.salario());
		System.out.println("Salário Diretor é: "+diretor.salario());
		System.out.println("Salário Secretário é: "+secretario.salario());
		
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
		secretario.autenticar();
	}
	
	public static void teste(Pessoa pessoa) {
		System.out.println("Essa pessoa é demais - "+pessoa.getNome() + " e o salário é de: "+pessoa.salario());
	}

}
