package bean;

public class Monitor {
	private String cpf;
	private String nome;
	private String tel;
	private String rua;
	private String nro;
	private String bairro;
	private String cidade;

	public Monitor() {

	}

	public Monitor(String cpf, String nome, String tel, String rua, String nro, String bairro, String cidade) {
		this.cpf = cpf;
		this.nome = nome;
		this.tel = tel;
		this.rua = rua;
		this.nro = nro;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
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
		return "Monitor [cpf=" + cpf + ", nome=" + nome + ", tel=" + tel + ", rua=" + rua
				+ ", nro=" + nro + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

	public void add(Monitor monitor) {


	}


}
