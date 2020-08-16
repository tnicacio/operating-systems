package utils;

public enum ActionsEnum {

	fis(1), 
	pagina(2), 
	vir(3), 
	finalizar(4), 
	ler_b(4), 
	ler_w(5), 
	ler_l(6), 
	ler_q(7), 
	escrever_b(8), 
	escrever_w(9),
	escrever_l(10), 
	escrever_q(11),
	iniciar(12);

	private int action;

	ActionsEnum(int action) {
		this.action = action;
	}
	
	public int getValue() {
		return action;
	}

}
