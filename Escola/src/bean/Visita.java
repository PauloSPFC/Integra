package bean;

public class Visita {
	private int cod_visita;
	private String monitor;
	private String professor;
	private int cod_trajeto;
	private String data_visita;
	private String horario_visita;
	private int nro_alunos;
	
	public Visita() {
		
	}
	
	public Visita(int cod_visita, String monitor, String professor, int cod_trajeto, String data_visita, String horario_visita, int nro_alunos) {
		this.cod_visita = cod_visita;
		this.monitor = monitor;
		this.professor = professor;
		this.cod_trajeto = cod_trajeto;
		this.data_visita = data_visita;
		this.horario_visita = horario_visita;
		this.nro_alunos = nro_alunos;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getCod_trajeto() {
		return cod_trajeto;
	}

	public void setCod_trajeto(int cod_trajeto) {
		this.cod_trajeto = cod_trajeto;
	}

	public String getData_visita() {
		return data_visita;
	}

	public void setData_visita(String data_visita) {
		this.data_visita = data_visita;
	}

	public String getHorario_visita() {
		return horario_visita;
	}

	public void setHorario_visita(String horario_visita) {
		this.horario_visita = horario_visita;
	}

	public int getNro_alunos() {
		return nro_alunos;
	}

	public void setNro_alunos(int nro_alunos) {
		this.nro_alunos = nro_alunos;
	}

	public int getCod_visita() {
		return cod_visita;
	}

	public void setCod_visita(int cod_visita) {
		this.cod_visita = cod_visita;
	}

	
}
