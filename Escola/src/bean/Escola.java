package bean;

public class Escola {
	private int matricula;
	private String nome;
	private String rua;
	private int nro;
	private String bairro;
	private String cidade;
	private String tel;
	private String estado;
	
	public Escola(int matricula, String nome, String rua, int nro, String bairro, String cidade, String tel, String estado) {
		this.matricula = matricula;
		this.nome = nome;
		this.rua = rua;
		this.nro = nro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.tel = tel;
		this.estado = estado;
	}

	public Escola() {
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Escola [matricula=" + matricula + ", nome=" + nome + ", rua=" + rua + ", nro=" + nro + ", bairro="
				+ bairro + ", cidade=" + cidade + ", tel=" + tel + ", estado=" + estado + "]";
	}

	public void add(Escola escola) {
		
	}
	
	
}
