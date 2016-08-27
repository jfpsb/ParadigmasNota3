package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta classe é responsável por manipular as conexões criadas.
 * Ele lê as persistencias registradas no persistence.xml e cria um controlador de entidade 
 * de uma persitência defida.
 * 
 */
public class JPAUtil {
	
	/**
	 * Possui uma EntityManagerFactory que cria um EntityManager com a persistência definida.
	 * 
	 */
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("AwesomeMovies");
	
	/**
	 * Retorna uma EntityManager definido pela EntityManagerFactory
	 * @return Retorna um EntityManager
	 * 
	 */
	public EntityManager getEntityManager(){	
		return factory.createEntityManager();
	}
	
}
