package aulas;

public class Aula3 {
	public static void main(String[] args) {
		//Exercicio 2
		int[] list = {11, 7, 333, -20, -23, 63, -22, 501, 10000};
		int sum = 0;
		
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		
		int media = (sum / list.length);
		
		System.out.println("Exercicio 2");
		System.out.println("Soma = " + sum);
		System.out.println("Media = " + media);
		
		System.out.println("\nExercicio 3");
		
		//Exercicio 3
		int[] lista = {12, 5, -21, 10, -345, 22, 50, -125, 80, -1};
		int mult = 0;
		int nega = 0;
		int maior = 0;
		
		for (int i = 0; i < lista.length; i++) {
			if (mult == 0 && lista[i] > 0) {
				mult = lista[i];
			}
			if (lista[i] > 0) {
				mult *= lista[i];
			}
			if (lista[i] < 0) {
				nega++;
			}
			if (lista[i] > maior) {
				maior = lista[i];
			}
		}
		
		System.out.println("Multiplicados = " + mult);
		System.out.println("Numeros negativos = " + nega);
		System.out.println("Numero maior = " + maior);
		System.out.println("\nExercicio 4");
		
		//Exercicio 4
		char[] nome = {'A', 'n', 'a', ' ', 'S', 'a', 'n', 't', 'o', 's', '\n'};
		String name = "";
		String apelido = "";
		int countC = 0;
		int countV = 0;
		
		for (int i = 0; i < 3; i++) {
			name += nome[i];
		}
		
		for (int i = 4; i < 10; i++) {
			apelido += nome[i];
		}
		
		for (int i = 0; i < nome.length; i++) {
			if (nome[i] == 'A') {
				countV += 1;
			} else if (nome[i] == 'a') {
				countV += 1;
			} else if (nome[i] == 'o') {
				countV += 1;
			}
		}
		
		for (int i = 0; i < nome.length; i++) {
			if (nome[i] == 'n') {
				countC += 1;
			} else if (nome[i] == 'S') {
				countC += 1;
			} else if (nome[i] == 't') {
				countC += 1;
			} else if (nome[i] == 's') {
				countC += 1;
			}
		}
		
		System.out.println(apelido + ", " + name);
		System.out.println(countV);
		System.out.println(countC);
	}
}
