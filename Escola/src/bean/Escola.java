package bean;
public class Escola {
	private int matricula;
	private String nome;
	private String rua;
	private int nro;
	private String bairro;
	private String cidade;
	private int tel;
	
	public Escola(int matricula, String nome, String rua, int nro, String bairro, String cidade, int tel) {
		this.matricula = matricula;
		this.nome = nome;
		this.rua = rua;
		this.nro = nro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.tel = tel;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Escola [matricula=" + matricula + ", nome=" + nome + ", rua=" + rua + ", nro=" + nro + ", bairro="
				+ bairro + ", cidade=" + cidade + ", tel=" + tel + "]";
	}

	public void add(Escola escola) {
		
	}
	
	
}
