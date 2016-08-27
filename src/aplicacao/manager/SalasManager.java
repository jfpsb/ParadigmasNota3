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
	
	/**
	 * Cria uma entidade de Sala e persiste no banco.
	 * 
	 * @param nome Nome da Sala.
	 * @param nCol N�mero m�ximo de Colunas da Sala.
	 * @param nLin N�mero m�ximo de Linhas da Sala.
	 * @return Retorna verdadeiro se a sala foi criada.
	 */
	public static boolean criarSala(String nome, int nCol, int nLin){
		if(nCol > 0  && nLin > 0){
			Sala sala = new Sala(nome, nCol, nLin);
			dao.salva(sala);
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
	}
	
	/**
	 * Atualiza uma sala e persiste no Banco.
	 * @param sala Sala a ser atualizada.
	 */
	public static void atualizarSala(Sala sala){
		dao.atualizar(sala);
	}
	
	/**
	 * Retorna uma Lista com as Salas salvas no Banco.
	 * @return Lista de salas salvas.
	 */
	public static List<Sala> listarSalas(){
		return dao.listar();
	}
	//TODO: Listar Sala
	
}
