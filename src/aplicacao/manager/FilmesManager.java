package aplicacao.manager;

import java.util.ArrayList;
import java.util.List;

import entidades.Filme;
import util.DAO;

/**
 * Classe para controle de Filmes
 *
 */
public class FilmesManager {
	
	private static DAO<Filme> dao = new DAO<Filme>(Filme.class);
	/**
	  * Cria uma entidade de Filme e persiste a mesma no banco.
	  * 
	  * @param nome   Nome do Filme.
	  * @param islegendado    Está disponível Legenda.
	  * @param is3d		Está disponível 3D.
	  * @param sinopse  Sinopse.
	  * @param image   Diretorio ou link para Imagem.
	  * @param duracao    Duração do Filme.
	  * 
	  * @return Retorna verdade se foi criado
	  */
	public static boolean criarFilme(String nome, String sinopse, String imagem, int duracao){
		if(duracao > 0 && !nome.isEmpty()){
			Filme filme = new Filme(nome, sinopse, imagem, duracao);
			dao.salva(filme);
			return true;
		}
		return false;
	}
	
	/**
	  * Recebe uma entidade de filme e remove do Banco.
	  * 
	  * @param filme   Entidade de Filme.
	  */
	public static void removerFilme(Filme filme){
		dao.remover(filme);
	}
	
	/**
	  * Recebe uma entidade de filme e atualiza seus dados no Banco.
	  * 
	  * @param filme   Entidade de Filme.
	  */
	public static void atualizarFilme(Filme filme){		
		dao.atualizar(filme);
	}
	
	/**
	  * Recupera a lista de Filmes Cadastrados.
	  * 
	  * @return Lista de filmes.
	  */
	public static List<Filme> listarFilmes(){
		return dao.listar();
	}
	
	/**
	 * Busca uma lista de filmes que contem o texto de busca
	 * @param texto Elemento a ser buscado
	 * @return Lista de elemento que contem o texto em questão
	 */
	private static List<Filme> buscarFilme(String texto){
		List<Filme> aux = new ArrayList<Filme> ();
		for (Filme filme : listarFilmes()) {
			if(filme.getNome().contains(texto))
				aux.add(filme);
		}
		
		return aux;
	}
	
	
	
}
