package projeto_final_bloco_01.model;

public abstract class Game{
	int id;
	String nome;
	float preco;
	String restricaoIdade;
	public Game(int id, String nome, float preco, String restricaoIdade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.restricaoIdade = restricaoIdade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getRestricaoIdade() {
		return restricaoIdade;
	}
	public void setRestricaoIdade(String restricaoIdade) {
		this.restricaoIdade = restricaoIdade;
	}
	public void visualizar() {
		System.out.println("O nome do jogo é: "+nome);
		System.out.println("Seu preco é: "+preco);
		System.out.println("Esse jogo somente é permitido para +"+restricaoIdade);
	}
	
}
