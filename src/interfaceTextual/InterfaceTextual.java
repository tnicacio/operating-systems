package interfaceTextual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceTextual {

	private boolean iniciar;

	public InterfaceTextual() {
		try {
			Object[] inputData;
			do {
				inputData = getDataFromInput(readLine());
				printActionDone(inputData);
			} while (!inputData[0].equals("finalizar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String printActionDone(Object[] data) {
		String str = "";
		if (!isInitialized() && !data[0].equals("finalizar")) {
			return str;
		}
		
		for (int i = 0; i < data.length; i++) {
			if (!data[i].equals("-1") && !data[i].equals("")) {
				str += data[i] + " ";
			}
		}
		System.out.println(str);
		return str;
	}

	public String readLine() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = reader.readLine();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	/*
	 * Returns an array with the data of what was done: [comando, bits, arquivo, dado, endereco]
	 */
	public Object[] getDataFromInput(String line) {

		String[] input = line.trim().split("[,|,\s]+");
		String userCommand = input[0];

		// Object [] state = { userCommand, bits, arquivo, dado, endereco }
		Object[] state = { userCommand, "-1", "", "", "" };

		if (!isInitialized()) {

			if (userCommand.equals("iniciar")) {
				setInitialized(true);
			}
			return state;
		}

		switch (userCommand) {

		case "fis":
			state[1] = Integer.parseInt(input[1]);
			doFis(state[1]);
			break;

		case "pagina":
			state[1] = Integer.parseInt(input[1]);
			doPagina(state[1]);
			break;

		case "vir":
			state[1] = Integer.parseInt(input[1]);
			state[2] = input[2];
			doVir(state[1], state[2]);
			break;

		case "finalizar":
			setInitialized(false);
			doFinalizar();
			break;

		case "ler_b":
		case "ler_w":
		case "ler_l":
		case "ler_q":
			state[4] = input[1];
			doLer(state[4], userCommand);
			break;

		case "escrever_b":
		case "escrever_w":
		case "escrever_l":
		case "escrever_q":
			state[3] = input[1];
			state[4] = input[2];
			doEscrever(state[4], userCommand);
			break;
		}

		return state;
	}

	private void doEscrever(Object object, String userCommand) {
		// TODO Auto-generated method stub
		
	}

	private void doLer(Object object, String userCommand) {
		// TODO Auto-generated method stub
		
	}

	private void doFinalizar() {
		// TODO Auto-generated method stub
		
	}

	private void doVir(Object object, Object object2) {
		// TODO Auto-generated method stub
		
	}

	private void doPagina(Object object) {
		// TODO Auto-generated method stub
		
	}

	private void doFis(Object object) {
		// TODO Auto-generated method stub

	}

	private boolean isInitialized() {
		return iniciar;
	}

	private void setInitialized(boolean iniciar) {
		this.iniciar = iniciar;
	}

}
