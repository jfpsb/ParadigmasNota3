package entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * Classe que representa uma sala de Cinema
 *
 */
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getnCol() {
		return nCol;
	}

	public void setnCol(int nCol) {
		this.nCol = nCol;
	}

	public int getnLin() {
		return nLin;
	}

	public void setnLin(int nLin) {
		this.nLin = nLin;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
}
