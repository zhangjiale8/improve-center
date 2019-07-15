package com.zjl.javase.serialize;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5536236010576818681L;
	private String firstname;
	private String lastname;
	private int age;
	private Person spouse;
	private Gender gender;
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	public Person(String firstname, String lastname, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	public Person(String firstname, String lastname, int age, Person spouse, Gender gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.spouse = spouse;
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}

enum Gender
{
    MALE, FEMALE
}