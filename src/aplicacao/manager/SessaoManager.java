package aplicacao.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidades.Filme;
import entidades.Sala;
import entidades.Sessao;
import util.DAO;

/**
 * Classe para controle de sess�o
 *
 */
public class SessaoManager {
	
	private static DAO<Sessao> daoSessao = new DAO<>(Sessao.class);
	
	//TODO: Criar Sess�o (Se n�o existir sess�o no mesmo horario)
	
	public static boolean removerSessao(Sessao sessao, boolean ignorarReservas){
		if(ignorarReservas){
			//TODO: Informar para a classe resposavel remover todos os ingresso relacionado com a sessao
		}
		else{
			//TODO: Se existirem reservas n�o remover
			//TODO: Sen�o Remover
		}
		return false;
	}
	
	//TODO: Atualizar Sess�o
	
	/**
	 * Lista todas as sess�es salvas no banco 
	 * @return Lista as
	 */
	public static List<Sessao> listarSessao(){
		return daoSessao.listar();
	}
	
	/**
	 * Lista todas as sessao que ocorrem na data definida.
	 * @param data Data para ser pesquisada.
	 * @return Lista com Sessao.
	 */
	public static List<Sessao> listarSessaoPorHorario(LocalDateTime data){
		List<Sessao> aux = new ArrayList<Sessao>();
		for (Sessao sessao : listarSessao()) {
			LocalDateTime dataEnd = getLocalDateTimeDoFimDaSessao(sessao);
			if ((sessao.getData().isBefore(data) && dataEnd.isAfter(data)) ||
					sessao.getData().isEqual(data) || dataEnd.isEqual(data)){
				aux.add(sessao);
			}
		}
		return aux;
	}
	
	/**
	 * Lista todas as sessao que exibiram ou exibir�o o filme.
	 * @param filme Filme para ser pesquisado.
	 * @return Lista com Sessao.
	 */
	public static List<Sessao> listarSessaoPorFilme(Filme filme){
		List<Sessao> aux = new ArrayList<Sessao>();
		for (Sessao sessao : listarSessao()) {
			if (sessao.getFilme().equals(filme)){
				aux.add(sessao);
			}
		}
		return aux;
	}
	
	/**
	 * Lista todas as sessao que ocorrem na sala especifica
	 * @param sala Sala para ser pesquisada
	 * @return Lista com Sessao
	 */
	public static List<Sessao> listarSessaoPorSala(Sala sala){
		List<Sessao> aux = new ArrayList<Sessao>();
		for (Sessao sessao : listarSessao()) {
			if (sessao.getSala().equals(sala)){
				aux.add(sessao);
			}
		}
		return aux;
	}
	
	/**
	 * Retorna o Hor�rio de fim da Sess�o
	 * @param sessao Sessao que ir� ser verificada
	 * @return LocalDateTime com o fim da Sess�o
	 */
	public static LocalDateTime getLocalDateTimeDoFimDaSessao(Sessao sessao){
		return sessao.getData().plusMinutes(sessao.getFilme().getDuracao());
	}
	
	//TODO: Cria Reserva para a Sessao (Apenas se a sess�o ainda n�o ocorreu) e retorna a mesma (Para registrar no ingresso)
	//TODO: Contar quantas reservas existem para a sess�o
	//TODO: Contar quantas reservas ainda s�o suportadas para a sess�o.
	//TODO: Remover Reserva para uma sess�o (Buscar e remover em vez de enviar a sess�o)
	
}
