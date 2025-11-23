package br.com.fiap.gs.resource;

import br.com.fiap.gs.beans.MissaoDiaria;
import br.com.fiap.gs.bo.MissaoDiariaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/missao")
public class MissaoDiariaResource {

    private MissaoDiariaBO missaoBO;

    public MissaoDiariaResource() throws SQLException, ClassNotFoundException {
        missaoBO = new MissaoDiariaBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MissaoDiaria> listarMissoes() throws SQLException {
        return (ArrayList<MissaoDiaria>) missaoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirMissao(MissaoDiaria missao) throws SQLException {
        missaoBO.inserirBo(missao);
        return Response.status(Response.Status.CREATED).entity(missao).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarMissao(@PathParam("id") int id, MissaoDiaria missao) throws SQLException {
        missao.setId(id);
        missaoBO.atualizarBo(missao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarMissao(@PathParam("id") int id) throws SQLException {
        missaoBO.deletarBo(id);
        return Response.ok().build();
    }
}
