package aplicacao.manager;

import java.util.List;

import entidades.Sala;
import util.DAO;

/**
 * Classe para controle de Salas.
 *
 */
public class SalasManager {
	
	private static DAO<Sala> dao = new DAO<Sala>(Sala.class);
	private static boolean listChanged = true;
	private static List<Sala> salas = null;
	
	/**
	 * Cria uma entidade de Sala e persiste no banco.
	 * 
	 * @param nome Nome da Sala.
	 * @param nCol Número máximo de Colunas da Sala.
	 * @param nLin Número máximo de Linhas da Sala.
	 * @return Retorna verdadeiro se a sala foi criada.
	 */
	public static boolean criarSala(String nome, int nLin, int nCol){
		if(nCol > 0  && nLin > 0){
			Sala sala = new Sala(nome, nCol, nLin);
			dao.salva(sala);
			listChanged = true;
			return true;
		}
		return false;
			
	}
	
	/**
	 * Remove uma sala e persiste no Banco.
	 * @param sala Sala a ser removida.
	 */
	public static void removerSala(Sala sala){
		dao.remover(sala);
		listChanged = true;
	}
	
	/**
	 * Atualiza uma sala e persiste no Banco.
	 * @param sala Sala a ser atualizada.
	 */
	public static void atualizarSala(Sala sala){
		dao.atualizar(sala);
		listChanged = true;
	}
	
	/**
	 * Retorna uma Lista com as Salas salvas no Banco.
	 * @return Lista de salas salvas.
	 */
	public static List<Sala> listarSalas(){
		if(listChanged) salas = dao.listar();
		listChanged = false;
		return salas;
	}
	
}
