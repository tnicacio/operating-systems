package interfaceTextual;

import utils.DataIO;
import utils.ActionsEnum;
import manager.UnitManager;

public class InterfaceTextual {

	private boolean iniciar;
	private Object[] actionDone;

	public InterfaceTextual() {
		try {
			Object[] inputData;
			do {
				inputData = getDataFromInput(DataIO.readConsoleLine());
				getActionDoneAsString();
				setActionDone(null);
			} while (!inputData[0].equals(ActionsEnum.finalizar.name()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Returns an array with the data of what was done: [comando, bits, arquivo,
	 * dado, endereco]
	 */
	public Object[] getDataFromInput(String line) {

		String[] input = line.trim().split("[,|,\s]+");
		String userCommand = input[0];

		// Object [] state = { userCommand, bits, arquivo, dado, endereco }
		Object[] state = { userCommand, "-1", "", "", "" };

		if (!isInitialized()) {

			if (userCommand.equals(ActionsEnum.iniciar.name())) {
				doIniciar();
			}
			return state;
		}

		switch (userCommand) {

		case "fis":
			if (input.length == 2) {
				state[1] = Integer.parseInt(input[1]);
				doFis((int) state[1]);
			}
			break;

		case "pagina":
			if (input.length == 2) {
				state[1] = input[1];
				doPagina((int) state[1]);
			}
			break;

		case "vir":
			if (input.length == 3) {
				state[1] = input[1];
				state[2] = input[2];
				doVir((int) state[1], (String) state[2]);
			}
			break;

		case "finalizar":
			doFinalizar();
			break;

		case "ler_b":
		case "ler_w":
		case "ler_l":
		case "ler_q":
			if (input.length == 2) {
				state[4] = input[1];
				doLer((String) state[4], userCommand);
			}
			break;

		case "escrever_b":
		case "escrever_w":
		case "escrever_l":
		case "escrever_q":
			if (input.length == 3) {
				state[3] = input[1];
				state[4] = input[2];
				doEscrever((String) state[4], userCommand);
			}
			break;
		}

		return state;
	}

	private void doIniciar() {
		setInitialized(true);
		setActionDone(new Object[] {ActionsEnum.iniciar.name()});
		
	}

	public boolean opcaoValida(String input) {
		for (ActionsEnum opcao : ActionsEnum.values() ){
			if (opcao.name().equals(input)) {
				return true;
			}
		}
		return false;
	}

	private void doEscrever(String dado, String userCommand) {
		setActionDone(new Object[] {userCommand, dado});

	}

	private void doLer(String endereco, String userCommand) {
		setActionDone(new Object[] {userCommand, endereco});

	}

	private void doFinalizar() {
		setActionDone(new Object[] {ActionsEnum.finalizar.name()});
		setInitialized(false);
	}

	private void doVir(int bits, String arquivo) {
		setActionDone(new Object[] {ActionsEnum.vir.name(), bits, arquivo});

	}

	private void doPagina(int bits) {
		setActionDone(new Object[] {ActionsEnum.pagina.name(), bits});

	}

	private void doFis(int bits) {
		setActionDone(new Object[] {ActionsEnum.fis.name(), bits});

	}

	private boolean isInitialized() {
		return iniciar;
	}

	private void setInitialized(boolean iniciar) {
		this.iniciar = iniciar;
	}

	public Object[] getActionDone() {
		return actionDone;
	}
	
	public String getActionDoneAsString() {
		
		if (actionDone == null) {
			return "";
		}
		
		String actionData = "";
		for (int i = 0; i < actionDone.length; i ++) {
			actionData += actionDone[i] + " ";
		}
		if (!actionData.equals("")) {
			System.out.println(actionData);
		}
		return actionData;
	}

	public void setActionDone(Object[] objects) {
		this.actionDone = objects;
	}

}
