package aplicacao.manager;

import java.sql.Timestamp;
import java.util.List;

import entidades.Registro;
import util.DAO;

/**
 * Classe para controle de registros.
 * 
 * @author jfpsb
 *
 */
public class RegistroManager {
	private static DAO<Registro> dao = new DAO<Registro>(Registro.class);

	/**
	 * Cria objeto de registro e salva no banco.
	 * 
	 * @param msg
	 *            Mensagem do registro.
	 * @param data
	 *            Data em que registro foi feito.
	 * @return True se a inserção foi bem sucedida, false se não.
	 */
	public static boolean criarRegistro(String msg, Timestamp data) {

		if (!msg.isEmpty()) {
			Registro registro = new Registro(msg, data);
			dao.salva(registro);
			return true;
		}

		return false;
	}
	
	/**
	  * Recupera a lista de registros.
	  * 
	  * @return Lista de registros.
	  */
	public static List<Registro> listarFilmes(){
		return dao.listar();
	}
}
