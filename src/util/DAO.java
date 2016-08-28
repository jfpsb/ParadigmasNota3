package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import util.JPAUtil;

/**
 * Esta classe é responsável por manipular as conexões com o banco de dados.
 * Ela possui como parâmetro uma classe genérica como tipo para manipular os diferentes tipo de entidade.
 *
 * @param <T> Tipo da Classe.
 */
public class DAO<T> {

	private final EntityManager em;
	private final Class<T> classe;
	
	
	/**
	 * Cria uma classe DAO do tipo da classe que recebe como parametro.
	 * @param classe Tipo de uma classe.
	 */
	public DAO(Class<T> classe) {
		this.em = JPAUtil.getEntityManagerChild();
		this.classe = classe;
	}
	
	/**
	 * Salva uma entidade do tipo T.
	 * @param t Entidade do tipo T.
	 */
	public void salva(T t) {
		this.em.getTransaction().begin();
		this.em.persist(t);
		this.em.getTransaction().commit();
	}
	
	/**
	 * Remove uma entidade do tipo T.
	 * 
	 * @param t Entidade do tipo T.
	 */
	public void remover(T t) {
		this.em.getTransaction().begin();
		this.em.remove(em.merge(t));
		this.em.getTransaction().commit();
	}
	
	/**
	 * Atualiza uma entidade do tipo T.
	 * 
	 * @param t Entidade do tipo T.
	 */
	public void atualizar(T t) {
		this.em.getTransaction().begin();
		this.em.merge(t);
		this.em.getTransaction().commit();
	}
	
	/**
	 * Busca uma entidade do banco a partir de uma id definida.
	 * 
	 * @param id ID da Entidade.
	 * @return	Retorna um objeto do tipo T.
	 */
	public T buscar(int id) {
		return em.getReference(classe, id);
	}
	
	/**
	 * Recupera todas as entidades de T relacionadas no Banco.
	 * 
	 * @return Retorna uma Lista da entidade T.
	 */
	public List<T> listar() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}
	
	/**
	 * [Inseguro] Executa um SQL Script direto no banco. (Cuidado ao usar esta função, comandos como este podem mudar a estrutura do banco)
	 * 
	 * @param sql SQl Script.
	 * @return Retorna uma lista de resultados do Object, retorna null caso o comando em SQL não execute ou retorna vazio caso o não exista retorno após execução.
	 */
	public List<Object> ExecuteSQL(String sql) {
		return em.createQuery(sql).getResultList();									
	}
	
	/**
	 * [Inseguro] Executa um SQL Script direto no banco e indica se o sql retornou vazio. (Cuidado ao usar esta função, comandos como este podem mudar a estrutura do banco)
	 * 																		
	 * @param sql SQl Script.
	 * @return Retorna verdadeiro caso o SQL Script retorne vazio.
	 */
	public Boolean ExecuteSQLisEmpty(String sql) {
		return !em.createQuery(sql).getResultList().isEmpty();						
	}																					
	
}