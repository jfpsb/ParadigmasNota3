package aplicacao.manager;

import java.util.List;

import entidades.Sala;
import util.DAO;

/**
 * Classe para controle de Salas
 *
 */
public class SalasManager {
	
	private static DAO<Sala> dao = new DAO<Sala>(Sala.class);
	
	public static boolean criarSala(String nome, int nCol, int nLin){
		if(nCol > 0  && nLin > 0){
			Sala sala = new Sala(nome, nCol, nLin);
			dao.salva(sala);
			return true;
		}
		return false;
			
	}
	
	//TODO: Atualizar Sala
	//TODO: Remover Sala
	//TODO: Listar Sala
	
}
