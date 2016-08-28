package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta classe � respons�vel por manipular as conex�es criadas.
 * Ele l� as persistencias registradas no persistence.xml e cria um controlador de entidade 
 * de uma persit�ncia defida.
 * 
 */
public class JPAUtil {
	
	/**
	 * Possui uma EntityManagerFactory que cria um EntityManager com a persist�ncia definida.
	 * 
	 */
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("AwesomeMovies");
	private static EntityManager EntityManagerChild = null;
	
	/**
	 * Retorna um EntityManager que pode ser usado para conex�o e cria um caso esteja fechado ou inexistente
	 * @return Retorna um Entitymanager
	 */
	public static EntityManager getEntityManagerChild() {
		if(EntityManagerChild == null || !EntityManagerChild.isOpen()) EntityManagerChild = new JPAUtil().getEntityManager();
		return EntityManagerChild;
	}
	
	/**
	 * Fecha a conex�o EntityManager existente
	 */
	public static void closeEntityManagerChild() {
		if(EntityManagerChild != null)
		EntityManagerChild.close();
	}
	
	/**
	 * Retorna uma EntityManager definido pela EntityManagerFactory
	 * @return Retorna um EntityManager
	 * 
	 */
	public EntityManager getEntityManager(){	
		return factory.createEntityManager();
	}
	
	
	
}
