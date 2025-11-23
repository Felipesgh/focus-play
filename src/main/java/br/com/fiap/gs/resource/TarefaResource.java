package br.com.fiap.gs.resource;

import br.com.fiap.gs.beans.Tarefa;
import br.com.fiap.gs.bo.TarefaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/tarefa")
public class TarefaResource {

    private TarefaBO tarefaBO;

    public TarefaResource() throws SQLException, ClassNotFoundException {
        tarefaBO = new TarefaBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tarefa> listarTarefas() throws SQLException {
        return (ArrayList<Tarefa>) tarefaBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirTarefa(Tarefa tarefa, @Context UriInfo uriInfo) throws SQLException {
        tarefaBO.inserirBo(tarefa);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(tarefa.getId()));

        return Response.created(builder.build())
                .entity(tarefa)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarTarefa(@PathParam("id") int id, Tarefa tarefa) throws SQLException {
        tarefa.setId(id);
        tarefaBO.atualizarBo(tarefa);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarTarefa(@PathParam("id") int id) throws SQLException {
        tarefaBO.deletarBo(id);
        return Response.ok().build();
    }
}

