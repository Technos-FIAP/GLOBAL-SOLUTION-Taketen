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

import br.com.taketen.beans.Usuario;
import br.com.taketen.bo.UsuarioBO;

@Path("/usuario")
public class UsuarioResource {

private UsuarioBO usuarioBO = new UsuarioBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Usuario>) usuarioBO.secionarBo();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> buscarPorId(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
		return (ArrayList<Usuario>) usuarioBO.secionarPorIdBo(id);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Usuario usuario, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		usuarioBO.inserirBo(usuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(usuario.getIdUsuario()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Usuario usuario, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
		usuarioBO.atualizarBo(usuario);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		usuarioBO.deletarBo(id);
		return Response.ok().build();
	}
	
}
