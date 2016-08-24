package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("AwesomeMovies");
	
	public EntityManager getEntityManager(){	
		return factory.createEntityManager();
	}
	
}
