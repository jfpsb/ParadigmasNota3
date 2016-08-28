package aplicacao.manager;

import java.util.ArrayList;
import java.util.List;

import entidades.Filme;
import entidades.Funcionario;
import util.DAO;

/**
 * Classe para controle de funcionários/
 * 
 * @author jfpsb
 *
 */
public class FuncionarioManager {
	private static DAO<Funcionario> dao = new DAO<Funcionario>(Funcionario.class);

	/**
	 * Cria um funcionário e adiciona ao banco.
	 * 
	 * @param nome
	 *            Nome do funcionário
	 * @return Retorna true se salvou corretamente; falso se não
	 */
	public static boolean criarFuncionario(String nome) {
		if (!nome.isEmpty()) {
			Funcionario funcionario = new Funcionario(nome);
			dao.salva(funcionario);
			return true;
		}

		return false;
	}

	/**
	 * Recebe uma entidade de funcionário e remove do Banco.
	 * 
	 * @param filme
	 *            Entidade de funcionário.
	 */
	public static void removerFuncionario(Funcionario f) {
		dao.remover(f);
	}

	/**
	 * Recebe uma entidade de funcionário e atualiza seus dados no Banco.
	 * 
	 * @param filme
	 *            Entidade de Funcionário.
	 */
	public static void atualizarFuncionario(Funcionario f) {
		dao.atualizar(f);
	}

	/**
	 * Recupera a lista de Funcionários Cadastrados.
	 * 
	 * @return Lista de funcionários.
	 */
	public static List<Funcionario> listarFuncionarios() {
		return dao.listar();
	}

	/**
	 * Busca uma lista de funcionários que contem o texto de busca
	 * 
	 * @param texto
	 *            Elemento a ser buscado
	 * @return Lista de elemento que contem o texto em questão
	 */
	private static List<Funcionario> buscarFuncionario(String texto) {
		List<Funcionario> aux = new ArrayList<Funcionario>();
		for (Funcionario f : listarFuncionarios()) {
			if (f.getNome().contains(texto))
				aux.add(f);
		}

		return aux;
	}
}
