package bean;

public class Professor {
	private int cpf;
	private String nome;
	private int matricula_escola;
	private int tel;
	
	public Professor() {
		
	}
	
	public Professor(int cpf, String nome, int matricula_escola) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.matricula_escola = matricula_escola;
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


	public int getMatricula_escola() {
		return matricula_escola;
	}


	public void setMatricula_escola(int matricula_escola) {
		this.matricula_escola = matricula_escola;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
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
