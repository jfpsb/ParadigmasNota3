package aplicacao.manager;

import java.util.List;

import entidades.Filme;
import entidades.Funcionario;
import entidades.Ingresso;
import entidades.Reserva;
import util.DAO;

/**
 * Classe para controle de ingresso.
 * 
 * @author jfpsb
 *
 */
public class IngressoManager {
	private static DAO<Ingresso> dao = new DAO<Ingresso>(Ingresso.class);

	/**
	 * Cria objeto de ingresso e salva no banco.
	 * 
	 * @param funcionario
	 *            Funcionário realizando a venda de ingresso.
	 * @param filme
	 *            Filme do ingresso.
	 * @param reserva
	 *            Reserva de poltrona.
	 * @param meia
	 *            Se o ingresso é meia-entrada.
	 * @param preco
	 *            Preço do ingresso.
	 * @return True se salvou corretamente, false se não.
	 */
	public static boolean criarIngresso(Funcionario funcionario, Filme filme, Reserva reserva, boolean meia,
			double preco) {

		if (funcionario != null && filme != null && reserva != null) {
			Ingresso ingresso = new Ingresso(funcionario, filme, reserva, meia, preco);
			dao.salva(ingresso);
			return true;
		}

		return false;
	}

	/**
	 * Remove um ingresso e persiste no Banco.
	 * 
	 * @param ingresso
	 *            Ingresso a ser removido.
	 */
	public static void removerSala(Ingresso ingresso) {
		dao.remover(ingresso);
	}

	/**
	 * Atualiza um ingresso e persiste no Banco.
	 * 
	 * @param ingresso
	 *            Ingresso a ser atualizada.
	 */
	public static void atualizarSala(Ingresso ingresso) {
		dao.atualizar(ingresso);
	}

	/**
	 * Recupera a lista de ingressos.
	 * 
	 * @return Lista de ingressos.
	 */
	public static List<Ingresso> listarFilmes() {
		return dao.listar();
	}
}
