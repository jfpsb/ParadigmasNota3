package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que representa um funcion�rio
 * 
 * @author jfpsb
 *
 */
@Entity
public class Funcionario {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 45)
	private String nome;

	/**
	 * Cria uma inst�ncia de funcion�rio.
	 * 
	 * @param id
	 *            Identificador de funcion�rio
	 * @param nome
	 *            Nome de Funcion�rio
	 */
	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	/**
	 * Retorna identificador de funcion�rio.
	 * 
	 * @return Inteiro que representa id de funcion�rio.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retorna nome de funcion�rio.
	 * 
	 * @return String que representa nome de funcion�rio.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui nome de funcion�rio.
	 * 
	 * @param nome
	 *            Nome a ser atribu�do.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
