package utils;

import manager.UnitManager;

public enum ActionsEnum {

	fis(1) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.fis(Integer.parseInt(input[1]));
			}
			return nope;
		}
	},
	pagina(2) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.pagina(Integer.parseInt(input[1]));
			}
			return nope;
		}
	},
	vir(3) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 3) {
				return UnitManager.vir(Integer.parseInt(input[1]), input[2]);
			}
			return nope;
		}
	},
	finalizar(4) {
		@Override
		public String doAction(String[] input) {
			if (input.length > 0) {
				return UnitManager.finalizar();
			}
			return nope;
		}
	},
	ler_b(4) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.ler_b(input[1]);
			}
			return nope;
		}
	},
	ler_w(5) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.ler_w(input[1]);
			}
			return nope;
		}
	},
	ler_l(6) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.ler_l(input[1]);
			}
			return nope;
		}
	},
	ler_q(7) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 2) {
				return UnitManager.ler_q(input[1]);
			}
			return nope;
		}
	},
	escrever_b(8) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 3) {
				return UnitManager.escrever_b(input[1], input[2]);
			}
			return nope;
		}
	},
	escrever_w(9) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 3) {
				return UnitManager.escrever_w(input[1], input[2]);
			}
			return nope;
		}
	},
	escrever_l(10) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 3) {
				return UnitManager.escrever_l(input[1], input[2]);
			}
			return nope;
		}
	},
	escrever_q(11) {
		@Override
		public String doAction(String[] input) {
			if (input.length == 3) {
				return UnitManager.escrever_q(input[1], input[2]);
			}
			return nope;
		}
	},
	iniciar(12) {
		@Override
		public String doAction(String[] input) {
			if (input.length > 0) {
				return UnitManager.iniciar();
			}
			return nope;
		}
	};

	private int action;
	private static String nope = "nope";

	ActionsEnum(int action) {
		this.action = action;
	}

	public int getValue() {
		return action;
	}

	public abstract String doAction(String[] input);

}
