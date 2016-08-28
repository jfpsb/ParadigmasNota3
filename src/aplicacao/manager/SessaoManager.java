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
	private static DAO<Ingresso> daoIngresso = new DAO<Ingresso>(Ingresso.class);
	
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
	
	/**
	 * Atualiza uma sessao sessao, se não existirem conflitos de horario e sala, a 
	 * sessão será criada e persistida no banco.
	 * @param sessao Sessao a ser atualizada 
	 * @param sala Referência da Sala.
	 * @param filme Referência do Filme.
	 * @param data Data de Inicio da Sessão.
	 * @param isLegendado Se a sessão é legendado.
	 * @param is3d Se a sessão é 3D.
	 * @param preco preço da entrada.
	 * @return Retorna verdade se a entidade for criada.
	 */
	public static boolean atualizarSessão(Sessao sessao, Sala sala, Filme filme, LocalDateTime data, boolean isLegendado, boolean is3d, double preco){
		
		List<Sessao> SessoesMarcadas = listarSessaoPorHorario(data);
		for (Sessao s1 : SessoesMarcadas) {
			if(s1.getSala().equals(sala)){
				return false;
			}
		}
		
		sessao.setSala(sala);
		sessao.setFilme(filme);
		sessao.setData(data);
		sessao.setIs3D(is3d);
		sessao.setLegendado(isLegendado);
		sessao.setPreco(preco);
		daoSessao.atualizar(sessao);
		
		return true;
	}
	
	/**
	 * Remove uma sessao do banco, caso não existam reservas. Se o parametro de ignorar estiver 
	 * verdadeiro as reservas subsequentes serão removidas.
	 * @param sessao Sessao a ser removida.
	 * @param ignorarReservas Booleana para ignorar reservas.
	 * @return Retorna Verdadeiro se a Sessão for removida
	 */
	public static boolean removerSessao(Sessao sessao, boolean ignorarReservas){
		if(ignorarReservas){
			for (Reserva reserva : listarReservasDaSessao(sessao)) {
				removerReserva(reserva);
			}
		}
		else{
			if(!listarReservasDaSessao(sessao).isEmpty()){
				System.out.println("ERROR: Sessao não removida! Existem reservas nesta sessão! Tente ignora-las!");	
				return false;
			}
		}
		
		daoSessao.remover(sessao);
		
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
	
	/**
	 * Faz a reserva de uma Poltrona
	 * @param sessao Sessao a qual a reserva vai ser feita
	 * @param ingresso Ingresso representativo a ser associada a reserva
	 * @param coluna Coluna da reserva que deseja
	 * @param linha Linha da reserva que deseja
	 * @return Retorna verdadeiro se a reserva foi concluida.
	 */
	public static boolean reservarPoltrona(Sessao sessao, Ingresso ingresso, int coluna, int linha){
		
		if(sessao == null && ingresso == null){
			System.out.println("ERROR: Parâmetros de Incorretos!");
			return false;
		}
		
		if (getLocalDateTimeDoFimDaSessao(sessao).isAfter(LocalDateTime.now())){
			System.out.println("ERROR: Sessao encerrada!");	
		}
		
		if(sessao.getSala().getnLin() < linha || sessao.getSala().getnCol() < coluna)
		
		for (Reserva reserva : listarReservasDaSessao(sessao)) {
			if(reserva.getLinha() == coluna && reserva.getColuna() == coluna){
				System.out.println("ERROR: Reserva já realizada! Tente de Novo.");
				return false;
			}
		}
		
		Reserva reserva = new Reserva(sessao, coluna, linha);
		
		reserva.setIngresso(ingresso);
		ingresso.setReserva(reserva);
		
		daoReserva.salva(reserva);
		daoIngresso.salva(ingresso);
		return true;
	}
	
	/**
	 * Listar todas as reservas feitas
	 * 
	 * @return Lista com as reservas
	 */
	public static List<Reserva> listarReservas(){
		daoReserva.listar();
		return null;
	}
	
	/**
	 * Lista com as reservas feitas para uma sessao específica.
	 * @param sessao Sessao a ser pesquisada.
	 * @return Retorna uma lista de sessoes realizadas.
	 */
	public static List<Reserva> listarReservasDaSessao(Sessao sessao){
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva reserva : listarReservas()) {
			if(reserva.getSessao().equals(sessao)){
				aux.add(reserva);
			}
		}
		return aux;
	}
	
	/**
	 * Lista com os ingressos feitos para uma sessao específica.
	 * @param sessao Sessao a ser pesquisada.
	 * @return Retorna uma lista de ingressos vendidos.
	 */
	public static List<Ingresso> listarIngressosDaSessao(Sessao sessao){
		List<Ingresso> aux = new ArrayList<Ingresso>();
		for (Reserva reserva : listarReservas()) {
			if(reserva.getSessao().equals(sessao)){
				aux.add(reserva.getIngresso());
			}
		}
		return aux;
	}
	
	/**
	 * Retorna o número de Reservas restantes
	 * @param sessao Sessão a ser pesquisada.
	 * @return Inteiro com quantidade
	 */
	public static int reservasRestantes(Sessao sessao){
		return sessao.getSala().getMaximoDePoltronas() - reservasRealizadas(sessao); 
	}
	
	/**
	 * Retorna o número de Reservas realizdas
	 * @param sessao Sessão a ser pesquisada.
	 * @return Inteiro com quantidade
	 */
	public static int reservasRealizadas(Sessao sessao){
		return listarReservasDaSessao(sessao).size();
	}
	
	/**
	 * Remove uma reserva e seu respectivo ingresso do Banco 
	 * @param reserva {@link Reserva} a ser removida
	 */
	public static void removerReserva(Reserva reserva){
		daoIngresso.remover(reserva.getIngresso());
		daoReserva.remover(reserva);
	}
}
	
	

