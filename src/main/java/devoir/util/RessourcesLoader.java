package devoir.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class RessourcesLoader {
	
	private static RessourcesLoader instance = null;
	
	private static final String ressourcesPath = "src/main/resources/";
	
	public static RessourcesLoader getInstance()
	{
		if (instance == null)
		{
			instance = new RessourcesLoader();
		}

		return instance;
	}
	
	public File loadRessourceFile(String filePath)
	{
		File file = new File(RessourcesLoader.ressourcesPath + filePath);
		return file;
	}
	
	private File loadFileTo(InputStream ins, String desFile)
	{
		try
		{
			ReadableByteChannel rbc = Channels.newChannel(ins);
			FileOutputStream fos = new FileOutputStream(desFile);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);	
			fos.close();
			
			return new File(desFile);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;

	}
	
	public Collection<File> downloadAndExtractZipFile(String url)
	{
		try
		{
			URL website = new URL(url);
			File zipFile = loadFileTo(website.openStream(), ressourcesPath + "temp.zip");
			Collection<File> res = unzipDataFile(new FileInputStream(zipFile));
			System.out.println(zipFile.getAbsolutePath());
			zipFile.delete();
			
			return res;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Collection<File> unzipDataFile(InputStream ins) throws Exception
	{
		ZipInputStream zipIn = new ZipInputStream(ins);
		ZipEntry entry = zipIn.getNextEntry();
		ArrayList<File> files = new ArrayList<>();
		while (entry != null)
		{
			String fileName = ressourcesPath + entry.getName();
			FileOutputStream fos = new FileOutputStream(fileName);
			zipIn.transferTo(fos);
			
			fos.close();
			
			files.add(new File(fileName));
			
			entry = zipIn.getNextEntry();
		}

		zipIn.close();
		
		return files;
	}
}
