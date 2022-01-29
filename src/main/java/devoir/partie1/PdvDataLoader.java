package devoir.partie1;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public class PdvDataLoader extends DefaultHandler{
	
	
	private PointDeVente pdv;
	
	private String elementContent;
	private EntityManager em;
	
	protected PdvDataLoader() throws Exception
	{
		elementContent = null;
		pdv = null;
		em = DBClient.getEntityManager();
	}
	
	public static void saveDataFromFileToDB(File fileStream) throws Exception
	{
		PdvDataLoader instance = new PdvDataLoader();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(fileStream, instance);
		
	}
	
	@Override
	public void startDocument()
	{
		em.getTransaction().begin();
	}
	
	@Override
	public void endDocument()
	{
		em.getTransaction().commit();
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
			
			String majDateStr = attrs.getValue("maj");
			
			LocalDateTime majDate = LocalDateTime.parse(majDateStr.replace(' ', 'T'));
			if (ChronoUnit.HOURS.between(majDate, LocalDateTime.now()) < 24)
			{				
				Carburant carburant = new Carburant();
				carburant.setNom(attrs.getValue("nom"));
				carburant.setPrix(Double.parseDouble(attrs.getValue("valeur")));
				carburant.setDatemsj(majDateStr);
				carburant.setPdv(pdv);
				pdv.getCarburants().add(carburant);
				carburant.setPdv(pdv);
				
				em.persist(carburant);
			}
			
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qname)
	{
		if (qname == "pdv")
		{
			em.persist(pdv);
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

}
