package com.mycompany.jakartademo.api;

import com.mycompany.jakartademo.business.Customer;
import com.mycompany.jakartademo.business.Directory;
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

@Path("customers")
public class CustomerApi {

    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Customer> getCustomers(@Context HttpServletRequest request){
	
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
            request.getSession().setAttribute("directory", d);
        }
        return d.getAll();
    }
    
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void postCustomer(Customer customer, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        d.add(customer);
        request.getSession().setAttribute("directory", d);
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    // Ici ce n'est plus Customer getById mais Response getById car on a personnalisé les reponses qui devaient
    // être données à l'utilisation et on retourne donc plus un customer mais une réponse
    // Si le customer existe la réponse correspond au customer, sinon elle correspond à un code/message d'erreur
    public Response getById(@PathParam("id") Long customerId, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        
        if(d == null) {
            d = new Directory();
        }
        Optional<Customer> oc = d.findById(customerId);
        
        if(oc.isPresent()){
                return Response.ok(oc.get()).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Customer Not Found").build();
            }
    }
    
    @Path("/{id}")
    @DELETE()
    public void delete(@PathParam("id") Long customerId, @Context HttpServletRequest request) {
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        d.delete(customerId);
    }
    
    @Path("/{id}")
    @PUT()
    public void update(Customer customerToUpdate, @Context HttpServletRequest request){
        
        Directory d = (Directory)request.getSession().getAttribute("directory");
        if(d == null) {
            d = new Directory();
        }
        d.update(customerToUpdate);
    }
}