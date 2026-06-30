package projeto_final_bloco_01.Repository;
import projeto_final_bloco_01.model.Game;

public interface GameRepository {
		// CRUD
		public void listarTodas();
		public void cadastrar(Game game);
		public void procurarPorId(int id);
		public void atualizar(Game game);
		public void deletar(int id);
		public void listarPorNome(String nome);
		
}
