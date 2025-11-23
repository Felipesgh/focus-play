package br.com.fiap.gs.resource;

import br.com.fiap.gs.beans.Usuario;
import br.com.fiap.gs.bo.RankingBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/ranking")
public class RankingResource {

    private RankingBO rankingBO;

    public RankingResource() throws SQLException, ClassNotFoundException {
        rankingBO = new RankingBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> listarRanking() throws SQLException {
        List<Usuario> ranking = rankingBO.selecionarRankingBO();
        return new ArrayList<>(ranking);
    }
}
