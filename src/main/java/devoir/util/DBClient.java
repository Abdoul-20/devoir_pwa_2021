package devoir.util;

import java.util.HashMap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBClient {

	private static HashMap<String, DBClient> dbInstances;
	private EntityManager em;
	
	
	static
	{
		dbInstances = new HashMap<>();
	}
	
	public static void addDatabase(String dbName, String persistanceUnitName)
	{
		dbInstances.put(dbName, new DBClient(persistanceUnitName));
	}
	
	public static EntityManager getEntityManager(String dbName)
	{
		DBClient client = dbInstances.get(dbName);
		if (client != null)
			return client.em;
		
		throw new IllegalArgumentException("La base de données " + dbName + " n'est pas enregistrée");
	}
	
	public static void shutdown(String dbName)
	{
		getEntityManager(dbName).close();
		dbInstances.remove(dbName);
	}
	
	public static boolean isDBAdded(String dbName)
	{
		return dbInstances.containsKey(dbName);
	}
	
	protected DBClient(String dbUnit)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbUnit);
		em = emf.createEntityManager();
	}

}
