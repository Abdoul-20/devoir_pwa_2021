package devoir.partie1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PdvDataLoader extends DefaultHandler{
	
	private ArrayList<PointDeVente> pdvs;
	private PointDeVente pdv;
	
	private String elementContent;
	
	public PdvDataLoader()
	{
		elementContent = null;
		pdvs = new ArrayList<>();
	}
	
	public void saveDataFromFileToDB(String filePath, String dbUnit) throws Exception
	{
		readXMLFile(filePath);
		
		saveDataToDB(dbUnit);
		
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
	
	private void readXMLFile(String filePath) throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(filePath), this);
	}
	
	private void saveDataToDB(String dbUnit)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbUnit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(PointDeVente pdevente : pdvs)
		{
			em.persist(pdevente);
			List<Carburant> carburants = pdevente.getCarburants();
			for (Carburant carburant : carburants)
				em.persist(carburant);
		}
		
		em.getTransaction().commit();
	}

}
