package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Member;

public class MemberService {
	protected EntityManager em;
	   
	   public MemberService(EntityManager em) {
	      this.em = em;
	   }
	   
	   public Member createMember(int memberNumber, String surname, String firstname, String secondname) {
		   Member member = new Member();
		   member.setMemberNumber(memberNumber);
		   member.setSurname(surname);
		   member.setFirstname(firstname);
		   member.setSecondname(secondname);
		   em.persist(member);
		   
		   return member;
	   }
	   
	   public Member updateMember(int id, String surname, String firstname, String secondname, int memberNumber) {
		   Member member = em.find(Member.class, id);
		   if (member != null) {
			   member.setMemberNumber(memberNumber);
			   member.setSurname(surname);
			   member.setFirstname(firstname);
			   member.setSecondname(secondname);
			   
			   return member;
		   }
		   return null;
	   }
	   
	   public void removeMember(int id) {
		   Member member = em.find(Member.class, id);
		   if (member != null) {
			   em.remove(member);
		   }
	   }
	   
	   public List<Member> listAllMembers() {
		   String q = "SELECT m FROM Member m";
		   
		   TypedQuery<Member> query = em.createQuery(q, Member.class);
	      return query.getResultList();
		}
	   
	   public List<Member> listMembers(String name) {
		   String q = "SELECT m " + 
		         " FROM Member m " +
		         " WHERE m.surname = :name " +
		         "    OR m.firstName = :name " +
		         "    OR m.secondName = :name"; 
	      
	       TypedQuery<Member> query = em.createQuery(q, Member.class).setParameter("name", name);
	      return query.getResultList();
		}
}
