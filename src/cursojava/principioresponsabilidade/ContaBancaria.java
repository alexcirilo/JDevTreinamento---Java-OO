package cursojava.principioresponsabilidade;

public class ContaBancaria {
	
	
	
	private String descricao;
	
	private double saldo = 8000;
	
	public void soma100Reais() {
		saldo += 100;
	}
	
	public void diminui100Reais() {
		saldo -=100;
	}
	
	public void sacarDinheiro(double saque){
		saldo -= saque;
	}
	
	public void depositarDinheiro(double dep) {
		saldo +=dep;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ContaBancaria [descricao=" + descricao + ", saldo=" + saldo + "]";
	}
	
	
}
