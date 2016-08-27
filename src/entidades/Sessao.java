package entidades;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe que representa uma sessão
 *
 */
@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	@Column
	private boolean isLegendado;
	
	@Column
	private boolean is3D;
	
	@Column
	private double preco;
	
	@Column
	private Timestamp data;


	/**
	 * Cria uma classe do tipo Sessao
	 * 
	 * @param sala 
	 * @param filme
	 * @param data 
	 * @param isLegendado
	 * @param is3d
	 * @param preco
	 */
	public Sessao(Sala sala, Filme filme, LocalDateTime data, boolean isLegendado, boolean is3d, double preco) {
		this.sala = sala;
		this.filme = filme;
		this.data = Timestamp.valueOf(data);
		this.isLegendado = isLegendado;
		this.is3D = is3d;
		this.preco = preco;
	}
	
	/**
	 * Recupera a Sala da Sessão.
	 * @return Retorna uma Sala.
	 */
	public Sala getSala() {
		return sala;
	}
	
	/**
	 * Define a sala onde irá ocorrer a sessão.
	 * @param sala Sala para a Sessão.
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	/**
	 * Recupera o Filme da Sessão.
	 * @return Retorna um Fala.
	 */
	public Filme getFilme() {
		return filme;
	}
	
	/**
	 * Define o filme que vai ser exibido na sessão.
	 * @param sala Filme para a Sessão.
	 */
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	/**
	 * Informa se o filme da Sessão é legendado.
	 * @return Retorna verdadeiro se o filme é legendado.
	 */
	public boolean isLegendado() {
		return isLegendado;
	}

	/**
	 * Define se o filme que vai ser exibido na sessão é legendado.
	 * @param sala Booleana para indicar se é legendado
	 */
	public void setLegendado(boolean isLegendado) {
		this.isLegendado = isLegendado;
	}

	/**
	 * Informa se o filme da Sessão é 3D.
	 * @return Retorna verdadeiro se o filme é legendado.
	 */
	public boolean isIs3D() {
		return is3D;
	}

	/**
	 * Define se o filme que vai ser exibido na sessão é legendado.
	 * @param sala Booleana para indicar se é legendado
	 */
	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}
	
	/**
	 * Recupera o preço da Sessão.
	 * @return Retorna um Double com o preço.
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Define o preço da sessão.
	 * @param preco Double com um preço.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Retorna a hora de inicio da Sessão.
	 * @return Retorna um LocalDateTime com a hora de inicio da sessão.
	 */
	public LocalDateTime getData() {
		return data.toLocalDateTime();
	}
	
	/**
	 * Define a data da Sessão.
	 * @param data LocalDateTime com a data.
	 */
	public void setData(LocalDateTime data) {
		this.data = Timestamp.valueOf(data);
	}
	
	/**
	 * Retorna a referência de Identificação da Sessão.
	 * <br/> Possui um valor @id usado para identificar a entidade no banco.
	 * @return Inteiro com ID.
	 */
	public int getId() {
		return id;
	}
	
}
