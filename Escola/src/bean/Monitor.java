package bean;

public class Monitor {
	private int cpf;
	private String nome;
	private double salario;
	private int tel;
	private String rua;
	private int nro;
	private String bairro;
	private String cidade;
	
	public Monitor() {
		
	}
	
	public Monitor(int cpf, String nome, double salario, int tel, String rua, int nro, String bairro, String cidade) {
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
		this.tel = tel;
		this.rua = rua;
		this.nro = nro;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Monitor [cpf=" + cpf + ", nome=" + nome + ", salario=" + salario + ", tel=" + tel + ", rua=" + rua
				+ ", nro=" + nro + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

	public void add(Monitor monitor) {

		
	}

	
}
