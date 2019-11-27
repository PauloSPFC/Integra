package bean;

public class Professor {
	private String cpf;
	private String nome;
	private int matricula_escola;
	private String tel;
	
	public Professor() {
		
	}
	
	public Professor(String cpf, String nome, int matricula_escola, String tel) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.matricula_escola = matricula_escola;
		this.tel = tel;
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
		return "Professor [cpf=" + cpf + ", nome=" + nome + ", matricula_escola=" + matricula_escola + ", tel=" + tel
				+ "]";
	}

	public void add(Professor professor) {

		
	}
		
}
