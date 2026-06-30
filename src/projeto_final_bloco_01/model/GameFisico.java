package projeto_final_bloco_01.model;

public class GameFisico extends Game{
	boolean novo;

	public GameFisico(int id, String nome, double preco, int restricaoIdade, boolean novo, int tipo) {
		super(id, nome, preco, restricaoIdade, tipo);
		this.novo = novo;
	}

	public boolean getNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	} 
	public void visulaizar() {
		super.visualizar();
		String novoString;
		if(novo) {
			novoString = "novo";
		}else {
			novoString = "usado";
		}
		System.out.println("O estado do jogo físico é: " + novoString);
	}
}
