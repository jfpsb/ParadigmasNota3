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
	private static boolean listChanged = true;
	private static List<Filme> filmes = null;
	/**
	  * Cria uma entidade de Filme e persiste a mesma no banco.
	  * 
	  * @param nome   Nome do Filme.
	  * @param islegendado    Est� dispon�vel Legenda.
	  * @param is3d		Est� dispon�vel 3D.
	  * @param sinopse  Sinopse.
	  * @param image   Diretorio ou link para Imagem.
	  * @param duracao    Dura��o do Filme.
	  * 
	  * @return Retorna verdade se foi criado
	  */
	public static boolean criarFilme(String nome, String sinopse, String imagem, int duracao){
		if(duracao > 0 && !nome.isEmpty()){
			Filme filme = new Filme(nome, sinopse, imagem, duracao);
			dao.salva(filme);
			listChanged = true;
			return true;
		}
		return false;
	}
	
	/**
	  * Recebe uma entidade de filme e remove do Banco.
	  * 
	  * @param filme   Entidade de Filme.
	  * @return Verdadeiro se o filme foi removido
	  */
	public static boolean removerFilme(Filme filme){
		if(SessaoManager.listarSessaoPorFilme(filme).size() > 0){
			return false;
		}
		dao.remover(filme);
		listChanged = true;
		return true;
	}
	
	/**
	  * Recebe uma entidade de filme e atualiza seus dados no Banco.
	  * 
	  * @param filme   Entidade de Filme.
	  */
	public static void atualizarFilme(Filme filme){		
		dao.atualizar(filme);
		listChanged = true;
	}
	
	/**
	  * Recupera a lista de Filmes Cadastrados.
	  * 
	  * @return Lista de filmes.
	  */
	public static List<Filme> listarFilmes(){
		if(listChanged) filmes = dao.listar();
		listChanged = false;
		return filmes;
	}
	
	/**
	 * Busca uma lista de filmes que contem o texto de busca
	 * @param texto Elemento a ser buscado
	 * @return Lista de elemento que contem o texto em quest�o
	 */
	public static List<Filme> buscarFilme(String texto){
		List<Filme> aux = new ArrayList<Filme> ();
		for (Filme filme : listarFilmes()) {
			if(filme.getNome().contains(texto))
				aux.add(filme);
		}
		
		return aux;
	}
	
	
	
}
