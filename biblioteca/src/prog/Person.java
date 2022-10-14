package prog;

public class Person {
	
	public enum PersonType {
		STUDENT,
		REGULAR,
		NEW
	}
	
	private String name;
	private String surname;
	private int age;
	private PersonType type;
	
	public Person(String name, String surname, int age, PersonType type) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Person)) {
            return false;
        }
         
        Person c = (Person) o;
      
        return c.getName().equals(getName())
        		&& c.getSurname().equals(getSurname())
        		&& c.getAge() == getAge()
        		&& c.getType().equals(getType());
	}
}
