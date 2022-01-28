package devoir.util;

import java.io.File;

public class RessourcesLoader {
	
	private static RessourcesLoader instance = null;
	
	public static RessourcesLoader getInstance()
	{
		if (instance == null)
			instance = new RessourcesLoader();
		
		return instance;
	}
	
	public File loadRessourceFile(String filePath) throws Exception
	{
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filePath).toURI());
		
		return file;
	}
}
