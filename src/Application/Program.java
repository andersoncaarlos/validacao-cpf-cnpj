package Application;

import java.util.Scanner;

import Object.CNPJ;
import Object.CPF;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String numero;
		int opcao;
		String dv;
		
		System.out.println("--- Bem vindo ao Validador de CPF/CNPJ ---");		
		System.out.println("Você quer verificar CPF ou CNPJ? (1 - CPF | 2 - CNPJ)");
		opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("----------------------------------------------");
		
		switch (opcao) {
			case 1:	
				System.out.print("Digite o número do CPF(Somente números):");
				numero = sc.nextLine();
				while (numero.length() != 11) {
					System.out.println("CPF Incorreto!");
					System.out.print("Digite novamente: ");
					numero = sc.nextLine();
				}
				CPF cpf = new CPF(numero);
				dv = cpf.calculoCPF(cpf);
				System.out.println(dv);
				break;
	
			case 2:
				System.out.print("Digite o número do CNPJ(Somente números):");
				numero = sc.nextLine();
				while (numero.length() != 14) {
					System.out.println("CNPJ Incorreto!");
					System.out.print("Digite novamente: ");
					numero = sc.nextLine();
				}
				
				// 14522250000104
				CNPJ cnpj = new CNPJ(numero);
				dv = cnpj.calculoCNPJ(cnpj);
				System.out.println(dv);
				break;
	
			default: {
				System.out.println("Opção inválida!");
			}
		}		
		
		
		
		sc.close();

	}

}
