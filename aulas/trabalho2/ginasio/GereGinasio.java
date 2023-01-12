package ginasio;

import java.util.ArrayList;

interface Methods {
	public void validateEntryOut(String check, Conta conta);
	public void notifyTrain(Conta conta);
}

class GereGinasio extends GereConta implements Methods {
	
	protected ArrayList<Cliente> clientes = new ArrayList<>();
	protected ArrayList<String> colaboradores = new ArrayList<>();
	
	public void validateEntryOut(String newCheck, Conta conta) {
		Check check = new Check(newCheck, conta);
		for (int i = 0; i < contas.size(); i++) {
			if (conta.equals(contas.get(i))) {
				contas.get(i).addCheck(check);
			}
		}
	}
	
	public void notifyTrain(Conta conta) {
		
	}
}
