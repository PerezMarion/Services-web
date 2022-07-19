package com.poe.documentationonline.api;

import com.poe.documentationonline.dao.DocumentationDao;
import com.poe.documentationonline.entity.Documentation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

@Path("documentations")
public class DocumentationApi {
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Documentation> findAllDocumentations(@Context HttpServletRequest request){
	
        DocumentationDao dd = (DocumentationDao)request.getSession().getAttribute("documentationdao");
        if(dd == null) {
            dd = new DocumentationDao();
            request.getSession().setAttribute("documentationdao", dd);
        }
        return dd.findAllDocumentations();
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Documentation findDocumentationById(@PathParam("id") Long id, @Context HttpServletRequest request){
        
        DocumentationDao dd = (DocumentationDao)request.getSession().getAttribute("documentationdao");
        if(dd == null) {
            dd = new DocumentationDao();
        }
        return dd.findDocumentationById(id);
    }    
        
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void createDocumentation(Documentation documentation, @Context HttpServletRequest request){
        
        DocumentationDao dd = (DocumentationDao)request.getSession().getAttribute("documentationdao");
        if(dd == null) {
            dd = new DocumentationDao();
        }
        dd.createDocumentation(documentation);
        request.getSession().setAttribute("documentationdao", dd);
    }
    
    @Path("/{id}")
    @DELETE()
    public void deleteDocumentation(@PathParam("id") Long id, @Context HttpServletRequest request) {
        
        DocumentationDao dd = (DocumentationDao)request.getSession().getAttribute("documentationdao");
        if(dd == null) {
            dd = new DocumentationDao();
        }
        Documentation documentation = dd.findDocumentationById(id);
        dd.deleteDocumentation(documentation);
     
    }
    
    @Path("/{id}")
    @PUT()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void updateDocumentation(@PathParam("id") Long id, Documentation documentation, @Context HttpServletRequest request){
        
        DocumentationDao dd = (DocumentationDao)request.getSession().getAttribute("documentationdao");
        if(dd == null) {
            dd = new DocumentationDao();
        }
        dd.updateDocumentation(id, documentation);
    }
}