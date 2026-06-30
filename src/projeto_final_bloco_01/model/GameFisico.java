package projeto_final_bloco_01.model;

public class GameFisico extends Game{
	boolean novo;

	public GameFisico(int id, String nome, float preco, String restricaoIdade, boolean novo) {
		super(id, nome, preco, restricaoIdade);
		this.novo = novo;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	} 
}
