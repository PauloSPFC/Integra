package bean;

public class Professor {
	private int senha;
	private String cpf;
	private String nome;
	private int matricula_escola;
	private String tel;
	
	public Professor() {
		
	}
	
	public Professor(int senha,String cpf, String nome, int matricula_escola, String tel) {
		super();
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.matricula_escola = matricula_escola;
		this.tel = tel;
	}


	public String getCpf() {
		return cpf;
	}


	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
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


	public int getMatricula_escola() {
		return matricula_escola;
	}


	public void setMatricula_escola(int matricula_escola) {
		this.matricula_escola = matricula_escola;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Professor [senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", matricula_escola="
				+ matricula_escola + ", tel=" + tel + "]";
	}

	public void add(Professor professor) {

		
	}
		
}
