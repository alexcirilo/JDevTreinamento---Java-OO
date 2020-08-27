package cursojava.classes;

public abstract class Pessoa { /* Impede de instanciar esta classe*/ 
	protected String nome;
	protected int idade;
	protected String dataNascimento;
	protected String RG;
	protected String CPF;
	protected String nomeMae;
	protected String nomePai;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	public boolean pessoaMaiorIdade(){
		
		return idade >= 18; 
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", RG=" + RG
				+ ", CPF=" + CPF + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}
	
	public abstract double salario();
	
	
}
