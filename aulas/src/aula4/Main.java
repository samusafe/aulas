package aula4;

import java.util.ArrayList;
import java.util.Scanner;

import aula4.Despesas.despesaType;

public class Main {
	private static ArrayList<Utilizador> utilizadores = new ArrayList<>();
	
	static Utilizador utilizador = new Utilizador();
	
	public static void main(String[] args) {
		int option;
		do {
			Scanner menu = new Scanner(System.in);
			System.out.println("[1] Criar utilizador \n[2] Criar despesa \n[3] Ver utilizadores \n[4] Ver despesas");
			option = menu.nextInt();
			Scanner scan = new Scanner(System.in);
			switch(option) {
			case 1:
				System.out.println("Nome?");
				String nome = scan.nextLine();
				
				System.out.println("Email?");
				String email = scan.nextLine();
				
				System.out.println("Data de nascimento?");
				String nascimento = scan.nextLine();
				
				if (!addUtilizador(nome, email, nascimento)) {
					break;
				}
				break;
			case 2:
				System.out.println("Codigo do utilizador?");
				int codigo = scan.nextInt();
				
				if (!(checkUser(codigo) == null)) {
					System.out.println("Tipo de despesa? [1] Automovel [2] Alimentar [3] Outro");
					int type = menu.nextInt();
					despesaType typeI = null;
					
					if (type == 1) {
						typeI = despesaType.AUTOMOVEL;
					} else if (type == 2) {
						typeI = despesaType.ALIMENTAR;
					} else if (type == 3) {
						typeI = despesaType.OUTRO;
					}
					
					System.out.println("Valor gasto?");
					int gasto = menu.nextInt();
					
					System.out.println("Data da despesa?");
					String data = menu.nextLine();
					
					addDespesa(checkUser(codigo), typeI, gasto, data);
					break;
					
				}
				System.out.println("Não existe nenhum utilizador com esse codigo");
				break;
			case 3:
				if (hasUtilizadores() == false) {
					System.out.println("Não há utilizadores");
					break;
				}
				for (int i = 0; i < utilizadores.size(); i++) {
					System.out.println(utilizadores.get(i).getNome());
				}
				break;
			case 4:
				if (utilizador.hasDespesas() == false) {
					System.out.println("Não há despesas");
					break;
				}
				for (int i = 0; i < utilizador.despesas.size(); i++) {
					System.out.println(utilizador.despesas.get(i));
				}
				break;
			default:
				break;
			}
		} while (option != 0);
	}
	
	public static boolean addUtilizador(String nome, String email, String nascimento) {
		int codigo = utilizadores.size();
		Utilizador utilizador = new Utilizador(codigo, nome, email, nascimento);
		for (int i = 0; i < utilizadores.size(); i++) {
			if(utilizador.getNome().equals(utilizadores.get(i).getNome())) {
				return false;
			}
		}
		return utilizadores.add(utilizador);
	}
	
	public static Utilizador checkUser(int code) {
		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizadores.get(i).getCodigo() == code) {
				return utilizadores.get(i);
			}
		}
		return null;
	}
	
	public static void addDespesa(Utilizador utilizador, despesaType type, int gasto, String date) {
		int id = utilizador.despesas.size();
		Despesas despesa = new Despesas(utilizador, id, type, gasto, date);
		
		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizador.equals(utilizadores.get(i))) {
				utilizadores.get(i).addDespesa(despesa);
			}
		}
		
	}
	
	public void addDespesaToUser(Utilizador utilizador, Despesas despesa) {
		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizador.equals(utilizadores.get(i))) {
				utilizadores.get(i).addDespesa(despesa);
			}
		}
	}
	
	public static boolean hasUtilizadores() {
		return utilizadores.size() > 0;
	}
}
