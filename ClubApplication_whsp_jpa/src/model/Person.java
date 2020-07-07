package model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	private String firstname;
	private String secondname;
	private String surname;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String firstname, String secondname, String surname) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", secondname=" + secondname + ", surname=" + surname + "]";
	}

}
