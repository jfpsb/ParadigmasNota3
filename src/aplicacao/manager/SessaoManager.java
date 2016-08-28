package aplicacao.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import entidades.Filme;
import entidades.Ingresso;
import entidades.Reserva;
import entidades.Sala;
import entidades.Sessao;
import util.DAO;

/**
 * Classe para controle de sessão
 *
 */
public class SessaoManager {
	
	private static DAO<Sessao> daoSessao = new DAO<Sessao>(Sessao.class);
	private static DAO<Reserva> daoReserva = new DAO<Reserva>(Reserva.class);
	
	/**
	 * Cria uma entidade de sessao, se não existirem conflitos de horario e sala, a 
	 * sessão será criada e persistida no banco. 
	 * @param sala Referência da Sala.
	 * @param filme Referência do Filme.
	 * @param data Data de Inicio da Sessão.
	 * @param isLegendado Se a sessão é legendado.
	 * @param is3d Se a sessão é 3D.
	 * @param preco preço da entrada.
	 * @return Retorna verdade se a entidade for criada.
	 */
	public static boolean criarSessão(Sala sala, Filme filme, LocalDateTime data, boolean isLegendado, boolean is3d, double preco){
		
		List<Sessao> SessoesMarcadas = listarSessaoPorHorario(data);
		for (Sessao sessao : SessoesMarcadas) {
			if(sessao.getSala().equals(sala)){
				return false;
			}
		}
		
		Sessao sessao = new Sessao(sala, filme, data, isLegendado, is3d, preco);
		daoSessao.salva(sessao);
		return true;
	}
	
	public static boolean removerSessao(Sessao sessao, boolean ignorarReservas){
		if(ignorarReservas){
			//TODO: Informar para a classe resposavel remover todos os ingresso relacionado com a sessao
		}
		else{
			//TODO: Se existirem reservas não remover
			//TODO: Senão Remover
		}
		return false;
	}
	
	/**
	 * Lista todas as sessões salvas no banco 
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
	 * Lista todas as sessao que exibiram ou exibirão o filme.
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
	 * Retorna o Horário de fim da Sessão
	 * @param sessao Sessao que irá ser verificada
	 * @return LocalDateTime com o fim da Sessão
	 */
	public static LocalDateTime getLocalDateTimeDoFimDaSessao(Sessao sessao){
		return sessao.getData().plusMinutes(sessao.getFilme().getDuracao());
	}
	
	public boolean reservarPoltrona(Sessao sessao, Ingresso ingresso, int coluna, int linha){
		if(sessao != null && ingresso != null){
			if (getLocalDateTimeDoFimDaSessao(sessao).isAfter(LocalDateTime.now())){
				//Reserva reserva = new Reserva(sessao, coluna, 0)
			}	
		}
		
		return false;
	}
	
	public List<Reserva> listarReservasDaSessao(){
		
		return null;
	}
	
		
	//TODO: Cria Reserva para a Sessao (Apenas se a sessão ainda não ocorreu) e retorna a mesma (Para registrar no ingresso)
	//TODO: Contar quantas reservas existem para a sessão
	//TODO: Contar quantas reservas ainda são suportadas para a sessão.
	//TODO: Remover Reserva para uma sessão (Buscar e remover em vez de enviar a sessão)
	
}
