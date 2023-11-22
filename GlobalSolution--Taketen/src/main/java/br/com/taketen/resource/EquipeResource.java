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

import br.com.taketen.beans.Equipe;
import br.com.taketen.bo.EquipeBO;

@Path("/equipe")
public class EquipeResource {

private EquipeBO equipeBO = new EquipeBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Equipe> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Equipe>) equipeBO.secionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Equipe equipe, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		equipeBO.inserirBo(equipe);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(equipe.getIdEquipe()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Equipe equipe, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
		equipeBO.atualizarBo(equipe);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		equipeBO.deletarBo(id);
		return Response.ok().build();
	}
	
}
