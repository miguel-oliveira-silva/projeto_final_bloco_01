package projeto_final_bloco_01;
import java.util.*;
import projeto_final_bloco_01.Controller.*;
import projeto_final_bloco_01.model.*;
public class Menu {
	private static final Scanner leia = new Scanner(System.in);
	private static final GameController gameController = new GameController();
	public static void main(String[] args) {
		int opcao;

		// Criar dados de teste
		criarGamesTeste();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                Loja de Games-GamesCO                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Game                           ");
			System.out.println("            2 - Listar todas os Games                ");
			System.out.println("            3 - Buscar Game por Id                   ");
			System.out.println("            4 - Atualizar Dados de um jogo           ");
			System.out.println("            5 - Apagar Jogo                          ");
			System.out.println("            6 - Consulta por nome do jogo            ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 6");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nGamesCo melhor loja de games do mundo");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Game\n\n");

				cadastrarGame();

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				listarGames();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				procurarGamePorId();
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				atualizarGame();
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				deletarGame();
				keyPress();
				break;
			case 6:
				System.out.println("Consulta por nome do jogo\n\n");
				listarPorTitulo();
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}


	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarGamesTeste() {
		gameController.cadastrar(
				new GameFisico(gameController.gerarId(), "Game of Waf", 250, 18, true ,1));
		gameController.cadastrar(
				new GameDigital(gameController.gerarId(), "Fortnite", 0.0, 12, "PS5", 2));
	}

	public static void listarGames() {
		gameController.listarTodas();
	}

	public static void cadastrarGame() {
		System.out.println("Digite o nome do jogo: ");
		String nome = leia.nextLine();
		
		System.out.println("Digite o preço do jogo: ");
		double preco = leia.nextDouble();
		leia.skip("\\R");
		
		System.out.println("Digite a restrição de idade do jogo: ");
		int restricao = leia.nextInt();
		
		System.out.println("Digite o tipo de jogo (1 - Fisíco | 2 - Digital): ");
		int tipo = leia.nextInt();
		leia.skip("\\R");
		switch (tipo) {
		case 1 -> {
			boolean novo;
			System.out.println("Digite y para uma mídia física nova ou n para uma usada: ");
			String novoString= leia.nextLine();
			if(novoString == "y") {
				novo = true;
			}else {
				novo = false;
			}
			gameController
					.cadastrar(new GameFisico(gameController.gerarId(), nome, preco, restricao, novo, tipo));
		}
		case 2 -> {
			System.out.println("Digite a plataforma do jogo digital: ");
			String plataforma = leia.nextLine();
			leia.skip("\\R");
			gameController
					.cadastrar(new GameDigital(gameController.gerarId(), nome, preco, restricao, plataforma, tipo));
		}
		default -> System.out.println("Tipo de game inválido!");
		}

	}

	public static void procurarGamePorId() {

		System.out.println("Digite o Id do jogo: ");
		int id = leia.nextInt();
		leia.nextLine();

		gameController.procurarPorId(id);

	}

	public static void deletarGame() {

		System.out.println("Digite o ID do jogo: ");
		int id = leia.nextInt();
		leia.nextLine();

		Optional<Game> game = gameController.buscarNaCollection(id);

		if (game.isPresent()) {

			// Confirmação da exclusão

			System.out.printf("\nTem certeza que você deseja excluir o jogo do ID %d (S/N)?", id);
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S"))
				gameController.deletar(id);
			else
				System.out.println("\nOperação cancelada!");

		} else {
			System.out.printf("\nO jogo de ID %d não foi encontrada!", id);
		}

	}

	public static void atualizarGame() {

		System.out.println("Digite o ID do jogo: ");
		int id = leia.nextInt();
		leia.nextLine();

		Optional<Game> game = gameController.buscarNaCollection(id);

		if (game.isPresent()) {
			// Obtém os dados atuais do game atual
			String nome = game.get().getNome();
			int restricaoIdade = game.get().getRestricaoIdade();
			double preco = game.get().getPreco();
			int tipo = game.get().getTipo();
			// Atualiza o titulo ou mantém o valor atual
			System.out.printf("Nome atual: %s"
					+ "%nDigite o nome do novo titulo (Pressione ENTER para manter o valor atual)", nome);
			String entrada = leia.nextLine();

			nome = entrada.isEmpty() ? nome : entrada;
			
			// Atualiza o saldo ou mantém o valor atual
			System.out.printf("Preço atual: %.2f"
					+ "%nDigite o novo preço (Pressione ENTER para manter o valor atual)", preco);
			entrada = leia.nextLine();

			preco = entrada.isEmpty() ? preco : Double.parseDouble(entrada.replace(",","."));
			
			System.out.printf("Restrição de idade atual: %d"
					+ "%nDigite a nova restrição de idade (Pressione ENTER para manter o valor atual)", restricaoIdade);
			entrada = leia.nextLine();

			
			switch(tipo) {
				case 1 ->{
					GameFisico gameFisico = (GameFisico) game.get();
					boolean novo = gameFisico.getNovo();
					// Atualiza o limite ou mantém o valor atual
					System.out.printf("Ele é novo: %b"
							+ "%nDigite y para mudar a condição (Pressione ENTER para manter o valor atual)", novo);
					entrada = leia.nextLine();
					novo = entrada.isEmpty() ? novo : !novo;
					
					gameController.atualizar(new GameFisico( id, nome, preco, restricaoIdade,  novo, tipo));
					
				}
				case 2 -> {
					GameDigital gameDigital = (GameDigital) game.get();
					String plataforma = gameDigital.getPlataformaDigital();
					
					// Atualiza o aniversario ou mantém o valor atual
					System.out.printf("Plataforma atual %s"
							+ "%nDigite a nova plataforma do jogo"
							+ "(Pressione ENTER para manter o valor atual)", plataforma);
					entrada = leia.nextLine();
	
					plataforma = entrada.isEmpty() ? plataforma: entrada;
					
					gameController.atualizar(new GameDigital( id, nome, preco, restricaoIdade,  plataforma, tipo));
				}
				default -> System.out.println("Tipo de game é inválido!");
			}

		} else {
			System.out.printf("\nO game ID %d não foi encontrada!", id);
		}

	}


	
	public static void listarPorTitulo(){
		
		System.out.println("Digite o nome do titulo do jogo: ");
		String nome = leia.nextLine();
		
		gameController.listarPorNome(nome);
	}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Miguel Oliveira da Silva");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/miguel-oliveira-silva");
		System.out.println("*********************************************************");
	}

}
