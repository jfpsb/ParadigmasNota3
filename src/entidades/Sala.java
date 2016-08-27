package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * Classe que representa uma sala de Cinema
 *
 */
@Entity
public class Sala {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 10)
	private String nome;
	
	@Column
	private int nCol;
	
	@Column
	private int nLin;

	/**
	 * Cria uma classe do tipo Sala
	 * @param nome Nome da Sala
	 * @param nCol Numero de Colunas da Sala
	 * @param nLin Numero de Linhas da Sala
	 */
	public Sala (String nome, int nCol, int nLin) {
		this.nome = nome;
		this.nCol = nCol;
		this.nLin = nLin;
	}
	
	/**
	 * Retorna o nome a sala.
	 * @return String com o nome da sala.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Define o nome da sala.
	 * @param nome String com o nome da sala
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o numéro de colunas de poltronas que a sala suporta
	 * @return Inteiro com a quantidade de colunas de poltronas.
	 */
	public int getnCol() {
		return nCol;
	}
	/**
	 * Define o numero de Colunas da Sala
	 * @param nCol Inteiro com a quantidade de colunas de poltronas da sala
	 */
	public void setnCol(int nCol) {
		this.nCol = nCol;
	}
	
	/**
	 * Retorna o numéro de linhas de poltronas que a sala suporta.
	 * @return Inteiro com a quantidade de linhas de poltronas.
	 */
	public int getnLin() {
		return nLin;
	}
	
	/**
	 * Define o numero de Colunas da Sala
	 * @param nLin Inteiro com a quantidade de linhas de poltronas da sala
	 */
	public void setnLin(int nLin) {
		this.nLin = nLin;
	}
	
	/**
	 * Retorna a referência de Identificação da sala.
	 * <br/> Possui um valor @id usado para identificar a entidade no banco.
	 * @return Inteiro com ID.
	 */
	public int getId() {
		return id;
	}
	
	
	
	
	
}
