package devoir.partie1;

import java.util.Collection;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import devoir.util.DBClient;
import devoir.util.MysqlClient;
import devoir.util.RessourcesLoader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@WebService()
@Path("/pdvs/")
public class PointsDeVenteService {
	
	private boolean dataLoaded;
	
	public PointsDeVenteService() throws Exception
	{
		dataLoaded = false;
	}
	
	@GET
	@Path("/test/")
	public Object testWS()
	{
		System.out.println("Web service marche !!");
		return null;
	}
	
	@GET
	@Path("/ville/{codePostal}/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getPointsDeVenteCP(@PathParam("codePostal") String codePostal)
	{
		EntityManager em = null;
		Collection<PointDeVente> pdvsCollection = null;
		try
		{
			initData();
			System.out.println("Invoke getPointDeVenteCP avec codePostale : " + codePostal);
			
			em = DBClient.getEntityManager(MysqlClient.class);
			
			pdvsCollection = em.createQuery("select pdv from PointDeVente pdv where pdv.cp = :codePostal", PointDeVente.class).
					setParameter("codePostal", codePostal).getResultList();
			if (pdvsCollection.isEmpty())
				return Response.status(Status.BAD_REQUEST).entity("Aucun point de vente trouvé dans la ville ayant le code postal : " + codePostal).build();
		}
		catch (Exception e)
		{
			shutdownDBWhenException(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred while gathering data").build();
		}
		return Response.ok().entity(pdvsCollection).build();
	}
	
	@GET
	@Path("/departement/{numeroDep}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getPointsDeVenteND(@PathParam("numeroDep")String numeroDepartement)
	{
		EntityManager em = null;
		Collection<PointDeVente> queryResult;
		try
		{	
			System.out.println("Invode getPointsDeVenteND avec numéroDapartement : " + numeroDepartement);
			initData();
			
			em = DBClient.getEntityManager(MysqlClient.class);
			CriteriaBuilder builder = em.getCriteriaBuilder();
			
			CriteriaQuery<PointDeVente> query = builder.createQuery(PointDeVente.class);
			Root<PointDeVente> pdvs = query.from(PointDeVente.class);
			query.select(pdvs);
			Expression<String> codePostalExpr = pdvs.get("cp").as(String.class);
			Predicate orRes = builder.or(
					builder.equal(builder.substring(codePostalExpr, 1, 2), numeroDepartement),
					builder.equal(builder.substring(codePostalExpr, 1, 3), numeroDepartement)
					);
			
			query.where(orRes);
			
			queryResult = em.createQuery(query).getResultList();
			
			if (queryResult.isEmpty())
				return Response.status(Status.BAD_REQUEST).entity("Aucun point de vente trouvé dans le département numéro : " + numeroDepartement).build();
			
		}
		catch (Exception e)
		{
			shutdownDBWhenException(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred while gathering data").build();
		}
		return Response.ok().entity(queryResult).build();
	}
	
	@GET
	@Path("/pdv/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getPointDeVente(@PathParam("id") String id)
	{
		EntityManager em = null;
		PointDeVente queryResult;
		try
		{	
			System.out.println("Invode getPointDeVente avec id : " + id);
			initData();
			
			em = DBClient.getEntityManager(MysqlClient.class);
			CriteriaBuilder builder = em.getCriteriaBuilder();
			
			CriteriaQuery<PointDeVente> query = builder.createQuery(PointDeVente.class);
			Root<PointDeVente> pdvs = query.from(PointDeVente.class);
			query.select(pdvs);
			Expression<String> idExpr = pdvs.get("id").as(String.class);
			query.where(builder.equal(idExpr, id));
			
			queryResult = em.createQuery(query).getSingleResult();
			
		}
		catch (NoResultException nre)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}
		catch (NonUniqueResultException nure)
		{
			throw nure;
		}
		catch (Exception e)
		{
			shutdownDBWhenException(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred while gathering data").build();
		}
		System.out.println(queryResult);
		return Response.ok().entity(queryResult).build();
	}
	
	@DELETE
	@Path("/pdv/{id}/{nomCarburant}")
	public Response deleteCarburant(@PathParam("id") String id, @PathParam("nomCarburant") String nomCarburant)
	{
		EntityManager em = null;
		try
		{	
			System.out.println("Invode deleteCarburant avec nomCarburant : " + nomCarburant);
			long idLong = Long.parseLong(id);
			em = DBClient.getEntityManager(MysqlClient.class);
			em.getTransaction().begin();
			int nbUpdates = em.createQuery("delete Carburant c where c.nom = :cnom and c.pdv.id = :id")
			.setParameter("cnom", nomCarburant).setParameter("id", idLong).executeUpdate();
			em.getTransaction().commit();
			em.clear();
			if (nbUpdates > 1)
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			if (nbUpdates == 0)
				return Response.status(Status.BAD_REQUEST).entity("Le carburant choisi est introuvable").build();
			
		}
		catch (Exception e)
		{
			shutdownDBWhenException(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting data").build();
		}
		return Response.ok().build();
	}
	@POST
	@Path("/pdv/{id}/{nomCarburant}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addCarburant(@PathParam("id") String id, @PathParam("nomCarburant") String nomCarburant, String prix)
	{
		EntityManager em = null;
		try
		{
			System.out.println("addCarburant : " + prix);
			long idLong = Long.parseLong(id);
			em = DBClient.getEntityManager(MysqlClient.class);
			em.getTransaction().begin();
			em.createQuery("update Carburant c set c.prix = :newPrix where c.pdv.id = :pdvId and c.nom = :nomCarburant").
			setParameter("nomCarburant", nomCarburant)
			.setParameter("newPrix", Double.parseDouble(prix)).setParameter("pdvId", idLong).executeUpdate();
			em.getTransaction().commit();
			em.clear();
			
		}
		catch (Exception e)
		{
			shutdownDBWhenException(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating data").build();
		}
		return getPointDeVente(id);
	}
	
	private void initData() throws Exception
	{
		if (!dataLoaded)
		{
			RessourcesLoader loader = RessourcesLoader.getInstance();
			PdvDataLoader.saveDataFromFileToDB(loader.loadRessourceFile("PrixCarburants_instantane.xml"));
			dataLoaded = true;
		}
	}
	
	private void shutdownDBWhenException(Exception e)
	{
		DBClient.shutdown();
		dataLoaded = false;
		e.printStackTrace();
	}
	

}
