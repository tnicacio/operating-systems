package interfaceTextual;

import utils.DataIO;
import utils.ActionsEnum;

public class InterfaceTextual {

	private boolean iniciar;
	private String[] actionDone;

	public InterfaceTextual() {
		try {
			String[] command = null;
			do {
				command = DataIO.readAndTreatConsoleLine();
				if (opcaoValida(command)) {
					DataIO.printAsStringLine(getActionDone());
				}
			} while (command != null && !command[0].equals(ActionsEnum.finalizar.name()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean opcaoValida(String[] input) {

		if (input == null) {
			return false;
		}

		String userCommand = input[0];

		if (!isInitialized()) {
			if (userCommand.equals(ActionsEnum.iniciar.name())) {
				setInitialized(true);
				setActionDone(input);
				return true;
			}
			return false;
		}

		for (ActionsEnum opcao : ActionsEnum.values()) {
			if (opcao.name().equals(input[0]) && !opcao.doAction(input).equals("nope")) {
				setActionDone(input);
				if (opcao.name().equals(ActionsEnum.finalizar.name())) {
					setInitialized(false);
				}
				return true;
			}
		}
		return false;
	}

	private boolean isInitialized() {
		return iniciar;
	}

	private void setInitialized(boolean iniciar) {
		this.iniciar = iniciar;
	}

	public String[] getActionDone() {
		return actionDone;
	}

	public void setActionDone(String[] actionDone) {
		this.actionDone = actionDone;
	}

}
