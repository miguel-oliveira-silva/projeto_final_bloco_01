package projeto_final_bloco_01.model;

public abstract class Game{
	int id;
	String nome;
	double preco;
	int restricaoIdade;
	int tipo;
	public Game(int id, String nome, double preco, int restricaoIdade, int tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.restricaoIdade = restricaoIdade;
		this.tipo = tipo;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getRestricaoIdade() {
		return restricaoIdade;
	}
	public void setRestricaoIdade(int restricaoIdade) {
		this.restricaoIdade = restricaoIdade;
	}
	public void visualizar() {
		System.out.println("O nome do jogo é: "+nome);
		System.out.println("Seu preco é: "+preco);
		System.out.println("Esse jogo somente é permitido para +"+restricaoIdade);
		switch (tipo) {
		case 1 -> System.out.println("Jogo Fisíco");
		case 2 -> System.out.println("Jogo Digital");
		default -> System.out.println("Inválido");
		}
	}
}
