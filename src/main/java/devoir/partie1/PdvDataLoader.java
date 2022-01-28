package devoir.partie1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import devoir.util.DBClient;
import devoir.util.MysqlClient;
import jakarta.persistence.EntityManager;

public class PdvDataLoader extends DefaultHandler{
	
	private ArrayList<PointDeVente> pdvs;
	private PointDeVente pdv;
	
	private String elementContent;
	
	protected PdvDataLoader()
	{
		elementContent = null;
		pdvs = new ArrayList<>();
	}
	
	private static EntityManager getEntityManager() throws Exception
	{
		return DBClient.getEntityManager(MysqlClient.class);
	}
	
	public static void saveDataFromFileToDB(File fileStream) throws Exception
	{
		PdvDataLoader instance = new PdvDataLoader();
		instance.readXMLFile(fileStream);
		
		instance.saveDataToDB();
		
	}
	
	@Override
	public void startElement(String uri, String name, String qname, Attributes attrs)
	{
		if (qname == "pdv")
		{
			pdv = new PointDeVente();	
			pdv.setId(Long.parseLong(attrs.getValue("id")));
			pdv.setCp(attrs.getValue("cp"));
		}
		else if (qname == "adresse" || qname == "ville")
		{
			elementContent = new String();
		}
		else if (qname == "prix")
		{
			Carburant carburant = new Carburant();
			carburant.setNom(attrs.getValue("nom"));
			carburant.setPrix(Double.parseDouble(attrs.getValue("valeur")));
			carburant.setDatemsj(attrs.getValue("maj"));
			carburant.setPdv(pdv);
			pdv.getCarburants().add(carburant);
			carburant.setPdv(pdv);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qname)
	{
		if (qname == "pdv")
		{
			pdvs.add(pdv);
		}
		else if (qname == "adresse")
		{
			pdv.setAdresse(elementContent);
			elementContent = null;
		}
		else if (qname == "ville")
		{
			pdv.setVille(elementContent);
			elementContent = null;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
	{
		
		if (elementContent != null)
		{
			String chars = new String(ch, start, length);
			elementContent += chars;
		}
	}
	
	@Override
	public String toString()
	{
		String res = "";
		for (PointDeVente pointDeVente : pdvs)
			res += pointDeVente + "\n";
		
		return res;
	}
	
	private void readXMLFile(File fileStream) throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(fileStream, this);
	}
	
	private void saveDataToDB() throws Exception
	{
		EntityManager entityManager = PdvDataLoader.getEntityManager();
		entityManager.getTransaction().begin();
		
		for(PointDeVente pdevente : pdvs)
		{
			entityManager.persist(pdevente);
			List<Carburant> carburants = pdevente.getCarburants();
			for (Carburant carburant : carburants)
				entityManager.persist(carburant);
		}
		
		entityManager.getTransaction().commit();
	}

}
