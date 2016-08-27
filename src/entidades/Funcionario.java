package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que representa um funcionário
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
	 * Cria uma instância de funcionário.
	 * 
	 * @param id
	 *            Identificador de funcionário
	 * @param nome
	 *            Nome de Funcionário
	 */
	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	/**
	 * Retorna identificador de funcionário.
	 * 
	 * @return Inteiro que representa id de funcionário.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retorna nome de funcionário.
	 * 
	 * @return String que representa nome de funcionário.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui nome de funcionário.
	 * 
	 * @param nome
	 *            Nome a ser atribuído.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
