package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe que representa um ingresso.
 * 
 * @author jfpsb
 *
 */
@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Funcionario funcionario;

	@ManyToOne
	private Filme filme;

	@OneToOne
	private Reserva reserva;

	@Column
	private boolean meia;

	/**
	 * Se for meia-entrada, será inserido em preço de ingresso o valor da sessão
	 * dividido por dois
	 */
	@Column
	private double preco;

	/**
	 * Cria o objeto do tipo ingresso.
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
	 */
	public Ingresso(Funcionario funcionario, Filme filme, boolean meia, double preco) {
		this.funcionario = funcionario;
		this.filme = filme;
		this.meia = meia;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public boolean isMeia() {
		return meia;
	}

	public void setMeia(boolean meia) {
		this.meia = meia;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}	
}
