package aplicacao.manager;

import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;
import util.DAO;

/**
 * Classe para controle de funcion�rios/
 * 
 * @author jfpsb
 *
 */
public class FuncionarioManager {
	private static DAO<Funcionario> dao = new DAO<Funcionario>(Funcionario.class);
	private static boolean listChanged = true;
	private static List<Funcionario> funcionarios = null;

	/**
	 * Cria um funcion�rio e adiciona ao banco.
	 * 
	 * @param nome
	 *            Nome do funcion�rio
	 * @return Retorna true se salvou corretamente; falso se n�o
	 */
	public static boolean criarFuncionario(String nome) {
		if (!nome.isEmpty()) {
			Funcionario funcionario = new Funcionario(nome);
			dao.salva(funcionario);
			listChanged = true;
			return true;
		}

		return false;
	}

	/**
	 * Recebe uma entidade de funcion�rio e remove do Banco.
	 * 
	 * @param filme
	 *            Entidade de funcion�rio.
	 */
	public static void removerFuncionario(Funcionario f) {
		dao.remover(f);
		listChanged = true;
	}

	/**
	 * Recebe uma entidade de funcion�rio e atualiza seus dados no Banco.
	 * 
	 * @param filme
	 *            Entidade de Funcion�rio.
	 */
	public static void atualizarFuncionario(Funcionario f) {
		dao.atualizar(f);
		listChanged = true;
	}

	/**
	 * Recupera a lista de Funcion�rios Cadastrados.
	 * 
	 * @return Lista de funcion�rios.
	 */
	public static List<Funcionario> listarFuncionarios() {
		if(listChanged) funcionarios = dao.listar();
		listChanged = false;
		return funcionarios;
	}

	/**
	 * Busca uma lista de funcion�rios que contem o texto de busca
	 * 
	 * @param texto
	 *            Elemento a ser buscado
	 * @return Lista de elemento que contem o texto em quest�o
	 */
	public static List<Funcionario> buscarFuncionario(String texto) {
		List<Funcionario> aux = new ArrayList<Funcionario>();
		for (Funcionario f : listarFuncionarios()) {
			if (f.getNome().contains(texto))
				aux.add(f);
		}

		return aux;
	}
}
