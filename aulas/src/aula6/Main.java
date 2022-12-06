package aula6;

import java.util.Scanner;

import aula6.Ingrediente.ingOrigin;
import aula6.Pizza.pizzaSize;

public class Main {

	public static void main(String[] args) {
		Scanner scanStr = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		System.out.println("Nome da ementa?");
		String design = scanStr.nextLine();
		
		System.out.println("Descrição da ementa");
		String desc = scanStr.nextLine();
		
		System.out.println("Codigo da ementa");
		int code = scanInt.nextInt();
		
		System.out.println("Data de hoje?");
		String startDate = scanStr.nextLine();
		
		Ementa ementa = new Ementa(design, desc, code, startDate, null, 0);
		
		int option;
		do {
			Scanner menu = new Scanner(System.in);
			System.out.println("\n[1] Criar pizza \n[2] Ver ementa \n[3] Editar pizzas");
			option = menu.nextInt();
			switch(option) {
			case 1:
				System.out.println("Nome da pizza?");
				String nome = scanStr.nextLine();
				
				System.out.println("Descrição da pizza?");
				String descPizza = scanStr.nextLine();
				
				System.out.println("Preço da pizza?");
				int price = scanInt.nextInt();
				
				System.out.println("Tamanho da pizza? [1] Pequena [2] Media [3] Familiar");
				int size = scanInt.nextInt();
				pizzaSize pizzaSize = null;
				if (size == 1) {
					pizzaSize = pizzaSize.PEQUENA;
				} else if (size == 2) {
					pizzaSize = pizzaSize.MEDIA;
				} else {
					pizzaSize = pizzaSize.FAMILIAR;
				}
				
				System.out.println("Quantos ingredientes tem?");
				int quant = scanInt.nextInt();
				
				Pizza pizza = new Pizza(0, nome, descPizza, price, pizzaSize, quant);
				ementa.getArrayList().add(pizza);
				
				for (int i = 0; i < quant; i++) {
					System.out.println("[" + (i++) + "] codigo?");
					int codigo = scanInt.nextInt();
					
					System.out.println("[" + (i++) + "] ingrediente?");
					String nomeIng = scanStr.nextLine();
					
					System.out.println("Origem do ingrediente? [1] Animal [2] Vegetal [3] Mineral");
					int ingOrig = scanInt.nextInt();
					ingOrigin ingOrigem = null;
					if (size == 1) {
						ingOrigem = ingOrigin.ANIMAL;
					} else if (size == 2) {
						ingOrigem = ingOrigin.ANIMAL;
					} else {
						ingOrigem = ingOrigin.MINERAL;
					}
					
					System.out.println("[" + (i++) + "] Quantidade de calorias?");
					int quantCal = scanInt.nextInt();
					
					Ingrediente ingrediente = new Ingrediente(codigo, nomeIng, ingOrigem, quantCal);
					pizza.ingredientes.add(ingrediente);
				}
				break;
			case 2:
				for (int i = 0; i < ementa.getArrayList().size(); i++) {
					System.out.println(ementa.getArrayList().get(i));
				}
				break;
			case 3:
				for (int i = 0; i < ementa.getArrayList().size(); i++) {
					System.out.println("[" + i + "]" + ementa.getArrayList().get(i));
				}
				break;
			default:
				break;
			}
		} while (option != 0);

	}
}
