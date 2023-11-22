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

import br.com.taketen.beans.Profissao;
import br.com.taketen.bo.ProfissaoBO;

@Path("/profissao")
public class ProfissaoResource {

private ProfissaoBO profissaoBO = new ProfissaoBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Profissao> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Profissao>) profissaoBO.secionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Profissao profissao, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		profissaoBO.inserirBo(profissao);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(profissao.getIdProfissao()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Profissao profissao, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
		profissaoBO.atualizarBo(profissao);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		profissaoBO.deletarBo(id);
		return Response.ok().build();
	}
	
}
