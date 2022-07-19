package com.poe.documentationonline.api;

import com.poe.documentationonline.dao.CategoryDao;
import com.poe.documentationonline.entity.Category;
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

@Path("categories")
public class CategoryApi {
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Category> findAllCategories(@Context HttpServletRequest request){
	
        CategoryDao cd = (CategoryDao)request.getSession().getAttribute("categorydao");
        if(cd == null) {
            cd = new CategoryDao();
            request.getSession().setAttribute("categorydao", cd);
        }
        return cd.findAllCategories();
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Category findCategoryById(@PathParam("id") Long id, @Context HttpServletRequest request){
        
        CategoryDao cd = (CategoryDao)request.getSession().getAttribute("categorydao");
        if(cd == null) {
            cd = new CategoryDao();
        }
        return cd.findCategoryById(id);
    }    
        
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void createCategory(Category category, @Context HttpServletRequest request){
        
        CategoryDao cd = (CategoryDao)request.getSession().getAttribute("categorydao");
        if(cd == null) {
            cd = new CategoryDao();
        }
        cd.createCategory(category);
        request.getSession().setAttribute("categorydao", cd);
    }
    
    @Path("/{id}")
    @DELETE()
    public void deleteCategory(@PathParam("id") Long id, @Context HttpServletRequest request) {
        
        CategoryDao cd = (CategoryDao)request.getSession().getAttribute("categorydao");
        if(cd == null) {
            cd = new CategoryDao();
        }
        Category category = cd.findCategoryById(id);
        cd.deleteCategory(category);
     
    }
    
    @Path("/{id}")
    @PUT()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void updateCategory(@PathParam("id") Long id, Category category, @Context HttpServletRequest request){
        
        CategoryDao cd = (CategoryDao)request.getSession().getAttribute("categorydao");
        if(cd == null) {
            cd = new CategoryDao();
        }
        cd.updateCategory(id, category);
    }
}