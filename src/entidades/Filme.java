package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que representa um filme
 *
 */
@Entity
public class Filme {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 32)
	private String nome;
	
	@Column(length = 200)
	private String sinopse;
	
	@Column
	private String imagem;
	
	@Column
	private int duracao;
	
	/**
	 * Cria uma classe Filmes.
	 * 
	 * @param nome   Nome do Filme.
	 * @param sinopse  Sinopse.
	 * @param image   Diretorio ou link para Imagem.
	 * @param duracao    Dura��o do Filme.
	 */
	public Filme(){}
	public Filme(String nome, String sinopse, String imagem, int duracao) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.imagem = imagem;
		this.duracao = duracao;
	}

	/**
	 * Retorna o Nome do Filme.
	 * @return String com nome.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recebe um valor pra nome.
	 * @param nome String com o novo valor pra nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna a sinopse do filme.
	 * @return String com sinopse.
	 */
	public String getSinopse() {
		return sinopse;
	}
	
	/**
	 * Define a sinopse do filme.
	 * @param sinopse Recebe uma string com uma sinopse e atualiza.
	 */
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	/**
	 * Retorna o endere�o ou link da imagem do filme.
	 * @return String com endere�o ou link.
	 */
	public String getImagem() {
		return imagem;
	}
	
	/**
	 * Define o endere�o ou link da imagem do filme.
	 * @param imagem Recebe uma string com endere�o ou link e atualiza.
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	/**
	 * Retorna a dura��o do filme.
	 * @return Inteiro com a dura��o.
	 */
	public int getDuracao() {
		return duracao;
	}
	
	/**
	 * Define a dura��o do filme.
	 * @param duracao Recebe um inteiro em minutos com dura��o do filme e atualiza.
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	/**
	 * Retorna a refer�ncia de Identifica��o do filme.
	 * <br/> Possui um valor @id usado para identificar a entidade no banco.
	 * @return Inteiro com ID.
	 */
	public int getId() {
		return id;
	}
	
	
}
