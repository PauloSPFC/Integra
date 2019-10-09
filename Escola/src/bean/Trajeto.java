package bean;

public class Trajeto {
	private String descricao;
	private int codigo;
	private double area;
	private double temp_media;
	private int tempo_passeio;
	
	public Trajeto() {
		
	}
	
	public Trajeto(String descricao, int codigo, double area, double temp_media, int tempo_passeio) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.area = area;
		this.temp_media = temp_media;
		this.tempo_passeio = tempo_passeio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getTemp_media() {
		return temp_media;
	}

	public void setTemp_media(double temp_media) {
		this.temp_media = temp_media;
	}

	public int getTempo_passeio() {
		return tempo_passeio;
	}

	public void setTempo_passeio(int tempo_passeio) {
		this.tempo_passeio = tempo_passeio;
	}

	@Override
	public String toString() {
		return "Trajeto [descricao=" + descricao + ", codigo=" + codigo + ", area=" + area + ", temp_media="
				+ temp_media + ", tempo_passeio=" + tempo_passeio + "]";
	}
	
}
