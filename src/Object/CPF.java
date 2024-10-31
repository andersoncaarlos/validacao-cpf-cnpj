package Object;

public class CPF {

	private String numero;

	public CPF() {
	}

	public CPF(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String calculoCPF(CPF cpf) {
		String num = cpf.getNumero().substring(0, 9);
		String arrayAux[] = new String[num.length()];
		int multiplicador = 10;
		int soma = 0;
		int resto = 0;
		int sub = 0;

		// Calculo primeiro digito verificador
		for (int i = 0; i < num.length(); i++) {
			arrayAux[i] = String.valueOf(Integer.valueOf(num.substring(i, i + 1)) * multiplicador);
			multiplicador--;
		}

		// Soma de acordo com a regra
		for (int i = 0; i < arrayAux.length; i++) {
			soma += Integer.valueOf(arrayAux[i]);
		}
		// Divisão de acordo com a regra
		resto = soma % 11;
		sub = 11 - resto;
		String dv = String.valueOf(sub);
		if (resto == 1 || resto == 0) {
			dv = "0";
		}

		// Resetando as variáveis para o segundo calculo
		num = cpf.getNumero().substring(0, 10);
		String[] arrayAux2 = new String[num.length()];
		multiplicador = 11;
		soma = 0;
		resto = 0;
		sub = 0;

		// Calculo segundo digito verificador
		for (int i = 0; i < num.length(); i++) {
			arrayAux2[i] = String.valueOf(Integer.valueOf(num.substring(i, i + 1)) * multiplicador);
			multiplicador--;
		}

		// Soma de acordo com a regra
		for (int i = 0; i < arrayAux2.length; i++) {
			soma += Integer.valueOf(arrayAux2[i]);
		}
		// Divisão de acordo com a regra
		resto = soma % 11;
		sub = 11 - resto;
		String dv2 = String.valueOf(sub);
		if (resto == 1 || resto == 0) {
			dv2 = "0";
		}

		if (cpf.getNumero().substring(9, 10).equals(dv)) {
			return "Confirmação de Digitos Verificadores:\n" + dv + " - (OK)\n" + dv2 + " - (OK)\n"
					+ "CPF informado é válido!";
		} else {
			return "CPF informado está inválido";
		}
	}
}
