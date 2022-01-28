package devoir.util;

import java.util.HashMap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DBClient {
	
	private static HashMap<Class<? extends DBClient>, DBClient> instances = new HashMap<>();

	
	private EntityManager em;
	
	public static <ClientClass extends DBClient> EntityManager getEntityManager(Class<ClientClass> clientClass) throws Exception
	{
		if (!instances.containsKey(clientClass))
		{
			DBClient instance = clientClass.getDeclaredConstructor().newInstance();
			instances.put(clientClass, instance);
		}
		EntityManager manager = instances.get(clientClass).em;
		/*if (!manager.isOpen())
		{
			DBClient instance = clientClass.getDeclaredConstructor().newInstance();
			instances.put(clientClass, instance);
			manager = instance.em;
		}*/
		
		return manager;
	}
	
	public static void shutdown()
	{
		for (DBClient c : instances.values())
			c.em.close();
		instances.clear();
	}
	
	protected DBClient(String dbUnit)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbUnit);
		em = emf.createEntityManager();
	}

}
