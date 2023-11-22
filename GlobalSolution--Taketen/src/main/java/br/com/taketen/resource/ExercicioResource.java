package br.com.taketen.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.taketen.beans.Exercicio;
import br.com.taketen.bo.ExercicioBO;

@Path("/exercicio")
public class ExercicioResource {

private ExercicioBO exercicioBO = new ExercicioBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Exercicio> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Exercicio>) exercicioBO.secionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Exercicio exercicio, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		exercicioBO.inserirBo(exercicio);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(exercicio.getIdExercicio()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Exercicio exercicio, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
		exercicioBO.atualizarBo(exercicio);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		exercicioBO.deletarBo(id);
		return Response.ok().build();
	}
	
}
