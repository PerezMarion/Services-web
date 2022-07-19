package com.mycompany.apiwebrestaurant.api;

import com.mycompany.apiwebrestaurant.business.Directory;
import com.mycompany.apiwebrestaurant.business.Meal;
import java.util.List;
import java.util.Optional;
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
import javax.ws.rs.core.Response;

@Path("meals")
public class MealApi {
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Meal> getMeals(@Context HttpServletRequest request){
	
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
            request.getSession().setAttribute("directory", d);
        }
        return d.getAll();
    }
    
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void addMeal(Meal meal, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        d.add(meal);
        request.getSession().setAttribute("directory", d);
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findMealById(@PathParam("id") Long id, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        
        if(d == null) {
            d = new Directory();
        }
        Optional<Meal> om = d.findById(id);
        
        if(om.isPresent()){
                return Response.ok(om.get()).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Customer Not Found").build();
            }
    }
    
    @Path("/{id}")
    @DELETE()
    public void deleteMeal(@PathParam("id") Long id, @Context HttpServletRequest request) {
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        Optional<Meal> om = d.findById(id);
        if(om.isPresent()) {
             d.delete(om.get());
        }
    }
    
    @Path("/{id}")
    @PUT()
    public void updateMeal(Meal meal, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        d.update(meal);
    }
}