package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_Fila = new ConcurrentLinkedQueue<>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_Fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Fila rodando");
		

		while (true) {
			Iterator iteracao = pilha_Fila.iterator();
			synchronized (iteracao) { // bloquear o acesso a esta lista por outros processos

				while (iteracao.hasNext()) { // enquanto tiver dados na lista irá processar
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();// pega o objeto atual

					// Processar 10 mil nfe
					// Gerar lista enorme de PDF
					// Gerar envio em massa de email
					iteracao.remove();

					System.out.println("----------------------");

					System.out.println("E-mail: "+processar.getEmail() + "\nNome: " + processar.getNome());

					try {
						Thread.sleep(1000); // dar tempo para descarga de memória
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			try {
				Thread.sleep(1000); // Processou toda a lista, dá um tempo pra limpeza de memória
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
