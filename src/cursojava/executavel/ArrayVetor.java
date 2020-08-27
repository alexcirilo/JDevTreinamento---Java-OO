package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double[] notas = { 8.8, 9.7, 6.6, 8 };
		double[] notasLogica = { 7.1, 5.8, 6.4, 6 };

		/* Criação do aluno */
		Aluno aluno = new Aluno();
		aluno.setNome("Alex Cirilo");
		aluno.setNomeEscola("JDev Treinamento");

		/* Criação da Disciplina */
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Curso de Java");
		disciplina.setNota(notas);

		aluno.getDisciplinas().add(disciplina);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Logica de Programação");
		disciplina2.setNota(notasLogica);

		aluno.getDisciplinas().add(disciplina2);

		System.out.println("------------------------------------------------------");
		
		Aluno[] arrayAlunos = new Aluno[1];
		arrayAlunos[0] = aluno;
		
		for(int pos =0; pos <arrayAlunos.length;pos++) {
			
			System.out.println("nome: "+arrayAlunos[pos].getNome());
			
			for(Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				
				System.out.println("Disciplina: "+d.getDisciplina());
				
				double maxNota =0.0;
				double minNota =0.0;
				for(int posNota = 0; posNota <d.getNota().length;posNota ++) {
					
					System.out.println("nota numero: "+posNota +" é: "+d.getNota()[posNota]);
					
					
					
					if(posNota == 0) {
						maxNota = d.getNota()[posNota];
					}else{
						if(maxNota < d.getNota()[posNota]) {
							maxNota = d.getNota()[posNota];
						}
					}
					
					if (posNota ==0) {
						minNota = d.getNota()[posNota];
						
					}else {
						if(minNota > d.getNota()[posNota]) {
							minNota = d.getNota()[posNota];
						}
					}
				}
				System.out.println("notaMax: "+maxNota);
				System.out.println("notaMin: "+minNota);
			}
			
		}
		
		
	}

}
