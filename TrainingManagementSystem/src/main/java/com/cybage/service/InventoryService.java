package com.cybage.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.omg.Messaging.SyncScopeHelper;

import com.cybage.dao.TrainerDAO;
import com.cybage.model.Login;
import com.cybage.model.Order;
import com.cybage.model.Trainer;

@Path("/trainer")
public class InventoryService {
	TrainerDAO dao=new TrainerDAO();
   @GET
   @Path("/trainerById/{trainerid}")
   @Produces(MediaType.APPLICATION_JSON)
   public Trainer getUserById(@PathParam("trainerid") Integer trainerId){
        Trainer trainer= dao.getTrainerById(trainerId);
       return trainer;
   }
   @POST
   @Path("/login")
   @Produces("text/plain")
   public String getAuthenticate(@QueryParam("username") String username,@QueryParam("password")String password){
        String result="failure";
      Login login = new Login();
      if (username.equals("vivek") && password.equals("12345"))
      {
    	  result ="success";
      }
      
       return result; 
   }
   @POST
   @Path("/register")
   @Produces("text/plain")
   @Consumes(MediaType.APPLICATION_JSON)
   public String getregister(Trainer tr){
        String result="failure";
      //Login login = new Login();
      System.out.println(tr.getTrainerAge());
       return tr.getTrainerName();
   }
   
   
}

