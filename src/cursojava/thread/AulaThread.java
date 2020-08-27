package cursojava.thread;

public class AulaThread {
	public static void main(String[] args) throws InterruptedException {

		for (int pos = 0; pos < 10; pos++) {
			
			/*Quero executar esse envio com um tempo de parada, ou com tempo determinado*/
			Thread.sleep(1000); // Tempo de execução (1s)

			System.out.println("Executando alguma rotina, por exemplo envio de e-mail");
		}

	}
}
