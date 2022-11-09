package prog;

import java.util.Scanner;

import prog.Person.PersonType;

public class Teste {
	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("[0] Terminar programa \n[1]Criar perfil \n[2]Criar livro");
		int option = menu.nextInt();
		switch (option) {
		case 1:
			System.out.println("Name?");
			String name = scanner.nextLine();
			
			System.out.println("Surname?");
			String surname = scanner.nextLine();
			
			System.out.println("Age?");
			int age = scanner.nextInt();
			
			System.out.println("What are you? [1] Student [2] Regular");
			int type = scanner.nextInt();
			if (type == 1) {
				Person person = new Person(name, surname, age, PersonType.STUDENT);
			}
			if (type == 2) {
				Person person = new Person(name, surname, age, PersonType.REGULAR);
			}
			System.out.println("sucess");
		default:
			break;
		} while (option != 0);
	}
}
