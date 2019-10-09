package bean;

public class Visita {
	private String monitor;
	private String professor;
	private int cod_trajeto;
	private String data_visita;
	private String horario_visita;
	
	public Visita(String monitor, String professor, int cod_trajeto, String data_visita, String horario_visita) {
		this.monitor = monitor;
		this.professor = professor;
		this.cod_trajeto = cod_trajeto;
		this.data_visita = data_visita;
		this.horario_visita = horario_visita;
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

	@Override
	public String toString() {
		return "Visita [monitor=" + monitor + ", professor=" + professor + ", cod_trajeto=" + cod_trajeto
				+ ", data_visita=" + data_visita + ", horario_visita=" + horario_visita + "]";
	}
	
	
}
