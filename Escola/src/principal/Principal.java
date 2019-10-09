package principal;

import java.util.ArrayList;

import bean.Pessoa;
import dao.EscolaDAO;

public class Principal {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		p1.setCodigo(2); p1.setNome("Paulo"); p1.setDiaNasc(16);  p1.setMesNasc(6); p1.setAnoNasc(2002); p1.setSexo("Masculino");
		p2.setCodigo(3); p2.setNome("José"); p2.setDiaNasc(25);  p2.setMesNasc(8); p2.setAnoNasc(1984); p2.setSexo("Não Identificado");
		
		EscolaDAO pp = new EscolaDAO();
		pp.inserir(p1);
		pp.inserir(p2);
		pp.alterar(p1);
		pp.remover(p2);
		
		ArrayList<Pessoa> pessoa = pp.getLista();
		for (Pessoa ps : pessoa) {
			System.out.println(ps.getNome() + " " + ps.getDiaNasc() + " " + ps.getMesNasc() + " " + ps.getAnoNasc() + " " + ps.getSexo());
		}
	}
}	
