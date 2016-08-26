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
	
	@Column
	private Boolean islegendado;
	
	@Column
	private Boolean is3D;
	
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
	 * @param islegendado    Est� dispon�vel Legenda.
	 * @param is3d		Est� dispon�vel 3D.
	 * @param sinopse  Sinopse.
	 * @param image   Diretorio ou link para Imagem.
	 * @param duracao    Dura��o do Filme.
	 */
	public Filme(String nome, Boolean islegendado, Boolean is3d, String sinopse, String imagem, int duracao) {
		this.nome = nome;
		this.islegendado = islegendado;
		this.is3D = is3d;
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
	 * Retorna se o filme � legendado.
	 * @return Retorna true para filme legendado e false para caso contr�rio.
	 */
	public Boolean getIslegendado() {
		return islegendado;
	}
	
	/**
	 * Define se o filme � legendado ou n�o.
	 * @param islegendado Recebe um booleano para indicar se � ou n�o � legendado.
	 */
	public void setIslegendado(Boolean islegendado) {
		this.islegendado = islegendado;
	}
	
	/**
	 * Retorna se o filme � 3D.
	 * @return Retorna true para filme 3D e false para caso contr�rio.
	 */
	public Boolean getIs3D() {
		return is3D;
	}
	
	/**
	 * Define se o filme � 3D ou n�o.
	 * @param is3d Recebe um booleano para indicar se � ou n�o � 3D.
	 */
	public void setIs3D(Boolean is3d) {
		is3D = is3d;
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
	 * Retorna a refer�ncia de Identifica��o do filme do Filme.
	 * <br/> Possui um valor @id usado para identificar a entidade no banco
	 * @return Inteiro com ID.
	 */
	public int getId() {
		return id;
	}
	
	
}
