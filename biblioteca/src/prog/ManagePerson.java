package prog;

import prog.Person.PersonType;

import java.util.ArrayList;

public class ManagePerson {
	
	private ArrayList<Person> persons = new ArrayList<>();
	
	public boolean newPerson(String name, String surname, int age, PersonType type) {
		Person person = new Person(name, surname, age, type);
		for(int i = 0; i < persons.size(); i++) {
			if (persons.get(i).equals(person)) {
				return false;
			}
		}
		return persons.add(person);
	}
	
	public Person searchPerson(String name, String surname) {
		for (int i = 0; i < persons.size(); i++) {
			if (name.equals(persons.get(i).getName()) && surname.equals(persons.get(i).getSurname())) {
				return persons.get(i);
			}
		}
		return null;
	}
}
