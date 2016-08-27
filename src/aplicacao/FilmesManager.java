package aplicacao;

import java.util.List;

import entidades.Filme;
import util.DAO;

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
	  */
	public static void CriarFilme(String nome, Boolean islegendado, Boolean is3d, String sinopse, String imagem, int duracao){
		Filme filme = new Filme(nome, islegendado, is3d, sinopse, imagem, duracao);
		dao.salva(filme);
	}
	
	/**
	  * Recebe uma entidade de filme e remove do banco.
	  * 
	  * @param filme   Entidade de Filme.
	  */
	public static void RemoverFilme(Filme filme){
		dao.remover(filme);
	}
	
	/**
	  * Recebe uma entidade de filme e atualiza seus dados no banco.
	  * 
	  * @param filme   Entidade de Filme.
	  */
	public static void AtualizarFilme(Filme filme){
		dao.atualizar(filme);
	}
	
	/**
	  * Recupera a lista de Filmes Cadastrados.
	  * 
	  * @return Lista de filmes.
	  */
	public static List<Filme> ListarFilmes(){
		return dao.listar();
	}
	
	
	
}
