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

import br.com.taketen.beans.Chatbot;
import br.com.taketen.bo.ChatbotBO;

@Path("/chatbot")
public class ChatbotResource {

private ChatbotBO chatbotBO = new ChatbotBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Chatbot> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Chatbot>) chatbotBO.secionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Chatbot chatbot, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		chatbotBO.inserirBo(chatbot);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(chatbot.getIdChatbot()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Chatbot chatbot, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
		chatbotBO.atualizarBo(chatbot);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		chatbotBO.deletarBo(id);
		return Response.ok().build();
	}
	
}
