package projeto_final_bloco_01.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import projeto_final_bloco_01.Repository.GameRepository;
import projeto_final_bloco_01.model.Game;
public class GameController implements GameRepository{
	private List<Game> listaGames = new ArrayList<Game>();
	int id = 0;
	
	@Override
	public void listarTodas() {
		for(var game : listaGames) {
			game.visualizar();
		}
	}

	@Override
	public void cadastrar(Game game) {
		listaGames.add(game);
		System.out.printf("O jogo: %s ID: %d cadastrado com sucesso%n",game.getNome(), game.getId());
	}

	@Override
	public void procurarPorId(int id) {
		
		Optional<Game> game = buscarNaCollection(id);
		
		if (game.isPresent())
			game.get().visualizar();
		else
			System.out.printf("\n O jogo com o id %d não foi encontrada!", id);
		
	}

	@Override
	public void atualizar(Game game) {
		
		Optional<Game> buscaGame = buscarNaCollection(game.getId());
		
		if (buscaGame.isPresent()) {
			listaGames.set(listaGames.indexOf(buscaGame.get()), game);
			System.out.printf("\n O jogo com o id %d foi atualizada com sucesso!", game.getId());
		}else
			System.out.printf("\nO jogo número %d não foi encontrada!", game.getId());
		
	}

	@Override
	public void deletar(int id) {

		Optional<Game> game = buscarNaCollection(id);
		
		if (game.isPresent()) {
			if (listaGames.remove(game.get()))
				System.out.printf("\nO jogo com o id %d foi excluída com sucesso!", id);
		}else
			System.out.printf("\nO jogo com o id %d não foi encontrada!", id);
		
	}

	
	
	@Override
	public void listarPorNome(String nome) {
		
		List<Game> listaNomes = listaGames.stream()
				.filter(game -> game.getNome().toUpperCase().contains(nome.toUpperCase()))
				.collect(Collectors.toList());
		
		if (listaNomes.isEmpty())
			System.out.printf("\nNenhum jogo com o nome %s foi encontrado.", nome);
		else
			listaNomes.forEach(game -> game.visualizar());
		
	}
	
	
	public int gerarId() {
		return ++ id;
	}
	
	public Optional<Game> buscarNaCollection(int id){
		for(var game : listaGames) {
			if (game.getId() == id)
				return Optional.of(game);
		}
		
		return Optional.empty();
	}
}
