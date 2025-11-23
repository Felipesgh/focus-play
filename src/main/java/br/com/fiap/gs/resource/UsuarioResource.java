package br.com.fiap.gs.resource;

import br.com.fiap.gs.beans.Usuario;
import br.com.fiap.gs.bo.UsuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO;

    public UsuarioResource() throws SQLException, ClassNotFoundException {
        usuarioBO = new UsuarioBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        return (ArrayList<Usuario>) usuarioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirUsuario(Usuario usuario, @Context UriInfo uriInfo) throws SQLException {
        usuarioBO.inserirBo(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(@PathParam("id") int id, Usuario usuario) throws SQLException {
        usuario.setId(id);
        usuarioBO.atualizarBo(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") int id) throws SQLException {
        usuarioBO.deletarBo(id);
        return Response.ok().build();
    }
}

