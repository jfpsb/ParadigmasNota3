package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe que representa uma reserva.
 * 
 * @author jfpsb
 *
 */
@Entity
public class Reserva {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Sessao sessao;

	@Column
	private int coluna;

	@Column
	private int linha;

	@Column
	private boolean reservado;

	/**
	 * Cria objeto do tipo reserva.
	 * 
	 * @param sessao
	 *            Sessão desta reserva.
	 * @param coluna
	 *            Coluna da poltrona reservada.
	 * @param linha
	 *            Linha da poltrona reservada.
	 */
	public Reserva(Sessao sessao, int coluna, int linha) {
		this.sessao = sessao;
		this.coluna = coluna;
		this.linha = linha;
	}

	public int getId() {
		return id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	
	
}
