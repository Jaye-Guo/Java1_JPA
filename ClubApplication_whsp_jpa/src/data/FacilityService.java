package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Facility;


public class FacilityService {
   protected EntityManager em;
   
   public FacilityService(EntityManager em) {
      this.em = em;
   }
   
   public Facility createFacility(String name, String description) {
      Facility fc = new Facility();
      fc.setName(name);
      fc.setDescription(description);
      em.persist(fc);
      
      return fc;
      
   }
   
   public Facility updateFacility(int id, String name, String description) {
      Facility fc = em.find(Facility.class, id);
      if (fc != null){
    	  fc.setName(name);
      	  fc.setDescription(description);
      	  return fc;}
      return null;
   }
   
   public void removeFacility(int id) {
	   Facility fc = em.find(Facility.class, id);
	   if (fc != null) {
		   em.remove(fc);
	   }
   }
   
   public Facility findFacility(int id) {
      Facility fc = em.find(Facility.class, id);
      return fc;
   }
   
   public List<Facility> listAllFacilities() {
	      String q = "SELECT f FROM Facility f";
	      
	      TypedQuery<Facility> query = em.createQuery(q, Facility.class);
	      return query.getResultList();
	   }
   
   public List<Facility> listFacilities(String name) {
	      String q = "SELECT f " + 
	            " FROM Facility f " +
	            " WHERE f.name LIKE :name ";
	            
	      TypedQuery<Facility> query = em.createQuery(q, Facility.class)
	            .setParameter("name", "%" + name + "%");
	      return query.getResultList();
	   }
}

