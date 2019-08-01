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

	private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
		// "Encrypt"/obscure the sensitive data
		age = age << 2;
		stream.defaultWriteObject();
	}

	private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
		stream.defaultReadObject();

		// "Decrypt"/de-obscure the sensitive data
		age = age << 2;
	}

	private Object writeReplace() throws java.io.ObjectStreamException {
		return new PersonProxy(this);
	}

}

enum Gender {
	MALE, FEMALE
}

class PersonProxy implements java.io.Serializable {
	public PersonProxy(Person orig) {
		data = orig.getFirstname() + "," + orig.getLastname() + "," + orig.getAge();
		if (orig.getSpouse() != null) {
			Person spouse = orig.getSpouse();
			data = data + "," + spouse.getFirstname() + "," + spouse.getLastname() + "," + spouse.getAge();
		}
	}

	public String data;

	private Object readResolve() throws java.io.ObjectStreamException {
		String[] pieces = data.split(",");
		Person result = new Person(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
		if (pieces.length > 3) {
			result.setSpouse(new Person(pieces[3], pieces[4], Integer.parseInt(pieces[5])));
			result.getSpouse().setSpouse(result);
		}
		return result;
	}
}