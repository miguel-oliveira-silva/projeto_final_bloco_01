package projeto_final_bloco_01.model;

public class GameDigital extends Game {
	String plataformaDigital;

	public GameDigital(int id, String nome, double preco, int restricaoIdade, String plataformaDigital, int tipo) {
		super(id, nome, preco, restricaoIdade, tipo);
		this.plataformaDigital = plataformaDigital;
	}

	public String getPlataformaDigital() {
		return plataformaDigital;
	}

	public void setPlataformaDigital(String plataformaDigital) {
		this.plataformaDigital = plataformaDigital;
	}
	
}
