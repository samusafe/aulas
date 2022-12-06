package aula8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int option;
		do {
			Scanner menu = new Scanner(System.in);
			System.out.println("\n[1] Criar veiculo \n[0] Terminar programa");
			option = menu.nextInt();
			switch(option) {
			case 1:
				Scanner select = new Scanner(System.in);
				System.out.println("Que tipo de veiculo e? [1] Carro [2] Bike [3] Truck");
				switch(select.nextInt()) {
				case 1:
					
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		} while (option != 0);
	}
}
