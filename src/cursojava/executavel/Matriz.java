package cursojava.executavel;

import javax.swing.JOptionPane;

public class Matriz {

	public static void main(String[] args) {
		
		
		int lin,col;
		lin = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de linhas: "));
		col = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de colunas: "));
		int notas[][] = new int[lin][col];
		
		/*notas[0][0] = 80;
		notas[0][1] = 90;
		notas[0][2] = 70;
		
		notas[1][0] = 40;
		notas[1][1] = 60;
		notas[1][2] = 30;*/
		
		for(int i =0; i<notas.length;i++) { //percorre as linhas
			System.out.println("------------------------------");
			/*Percorre as colunas*/
			for(int j = 0; j <notas[i].length; j++) {
				notas[i][j] = Integer.valueOf(JOptionPane.showInputDialog
						(" valor da Posição "+"["+(i+1)+"]" + "["+(j+1)+"]"));
				System.out.println(notas[i][j]);
			}
		}
	}

}
