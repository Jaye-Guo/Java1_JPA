package application;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data.FacilityService;
import data.MemberService;
import model.Facility;
import model.Member;

public class ClubApplication {
   public static void main(String[] args) {
      EntityManagerFactory emf =    
              Persistence.createEntityManagerFactory("JPAWorkshop");
      EntityManager em = emf.createEntityManager();
      FacilityService fs = new FacilityService(em);
      MemberService ms = new MemberService(em);

      // Filling your code to test the application
		
		
		  em.getTransaction().begin(); fs.createFacility("single room", "single bed");
		  fs.createFacility("double room", "double beds");
		  fs.createFacility("couple room", "queen size bed");
		  fs.createFacility("family room", "suit"); 
		  em.getTransaction().commit();
		  
		  em.getTransaction().begin(); 
		  fs.updateFacility(4, "business suit", "for business person"); 
		  em.getTransaction().commit();
		  
		  em.getTransaction().begin(); 
		  fs.removeFacility(2);
		  em.getTransaction().commit();
		  
		  Facility fc = fs.findFacility(5); System.out.println(fc);
		  
		  List<Facility> facilities = fs.listAllFacilities(); 
		  for (Facility facility : facilities) { System.out.println(facility); }
		  
		  List<Facility> facilities2 = fs.listFacilities("single"); 
		  for (Facility facility : facilities2) System.out.println(facility);
		 
		  em.getTransaction().begin(); 
		  ms.createMember(123, "GUO", "JIEYI", "JAYE");
		  ms.createMember(234, "GUO", "JIEYING", "JOEY"); 
		  ms.createMember(345, "GUO", "ZHENHUANG", "BRYANT"); 
		  ms.createMember(156, "ZHOU", "SICONG", null);
		  ms.createMember(543, "GUO", "YANCHUN", null); 
		  em.getTransaction().commit();
		  
		  em.getTransaction().begin(); 
		  ms.updateMember(2, "GUO", "TZ", null, 233);
		  em.getTransaction().commit();
		  
		  em.getTransaction().begin(); 
		  ms.removeMember(5);
		  em.getTransaction().commit();
		 
		
		  List<Member> memberlist = ms.listAllMembers(); 
		  for (Member member : memberlist) System.out.println(member);
		  
		  List<Member> memberlist2 = ms.listMembers("JAYE"); 
		  for (Member member : memberlist2) System.out.println(member);
		 
     
   }
   
}
