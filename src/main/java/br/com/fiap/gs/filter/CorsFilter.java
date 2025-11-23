package br.com.fiap.gs.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {
        
        // Permite TODOS os domínios do Vercel e localhost
        String origin = request.getHeaderString("Origin");
        if (origin != null) {
            response.getHeaders().add("Access-Control-Allow-Origin", origin);
        }
        
        response.getHeaders().add("Access-Control-Allow-Headers", 
            "origin, content-type, accept, authorization, x-requested-with");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH");
    }
}