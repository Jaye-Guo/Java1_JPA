package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "members")
public class Member extends Person {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private int memberNumber;
	
	public Member() {
	}

	public Member(String surname, String firstName, String secondName, int memberNumber) {
	      super(surname, firstName, secondName);
	      this.memberNumber = memberNumber;
	   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberNumber=" + memberNumber + ", toString()=" + super.toString() + "]";
	}

	
	
}
