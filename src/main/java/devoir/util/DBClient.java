package devoir.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBClient {
	
	private static DBClient instance = null;

	
	private EntityManager em;
	
	public static EntityManager getEntityManager() throws Exception
	{
		if (instance == null)
			instance = new DBClient("pwa-mysql");
		
		return instance.em;
	}
	
	public static void shutdown()
	{
		if (instance != null)
		{			
			instance.em.close();
			instance = null;
		}
	}
	
	protected DBClient(String dbUnit)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbUnit);
		em = emf.createEntityManager();
	}

}
