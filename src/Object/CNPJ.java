package Object;

public class CNPJ {

	private String numero;

	public CNPJ() {
	}

	public CNPJ(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String calculoCNPJ(CNPJ cnpj) {
		String num = cnpj.getNumero().substring(0, 12);
		String arrayAux[] = new String[num.length()];
		int multiplicador = 2;
		int valor = 0;
		int soma = 0;
		int resto = 0;
		int sub = 0;

		// Calculo primeiro digito verificador
		for (int i = num.length() - 1; i >= 0; i--) {
			valor = Character.getNumericValue(num.charAt(i));
			arrayAux[i] = String.valueOf(Integer.valueOf(valor * multiplicador));
			if (multiplicador < 9) {
				multiplicador++;
			} else {
				multiplicador = 2;
			}
		}
		// Soma de acordo com a regra
		for (int i = 0; i < arrayAux.length; i++) {
			soma += Integer.valueOf(arrayAux[i]);
		}

		// Divisão de acordo com a regra
		resto = soma % 11;
		sub = 11 - resto;
		String dv = String.valueOf(sub);
		if (resto == 1 || resto == 0 || resto == 10) {
			dv = "0";
		}

		// Resetando variáveis
		num = cnpj.getNumero().substring(0, 13);
		String[] arrayAux2 = new String[num.length()];
		multiplicador = 2;
		valor = 0;
		soma = 0;
		resto = 0;
		sub = 0;

		// Calculo segundo digito verificador
		for (int i = num.length() - 1; i >= 0; i--) {
			valor = Character.getNumericValue(num.charAt(i));
			arrayAux2[i] = String.valueOf(Integer.valueOf(valor * multiplicador));
			if (multiplicador < 9) {
				multiplicador++;
			} else {
				multiplicador = 2;
			}
		}

		// Soma de acordo com a regra
		for (int i = 0; i < arrayAux2.length; i++) {
			soma += Integer.valueOf(arrayAux2[i]);
		}

		// Divisão de acordo com a regra
		resto = soma % 11;
		sub = 11 - resto;
		String dv2 = String.valueOf(sub);
		if (resto == 1 || resto == 0 || resto == 10) {
			dv2 = "0";
		}

		if (cnpj.getNumero().substring(12, 13).equals(dv)) {
			return "Confirmação de Digitos Verificadores:\n" + dv + " - (OK)\n" + dv2 + " - (OK)\n"
					+ "CNPJ informado é válido!";
		} else {
			return "CNPJ inválido";
		}

	}

}
